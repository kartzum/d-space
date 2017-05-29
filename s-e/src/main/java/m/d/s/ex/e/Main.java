package m.d.s.ex.e;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.language.Metaphone;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.FilterFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.graphx.Edge;
import org.apache.spark.graphx.EdgeDirection;
import org.apache.spark.graphx.Graph;
import org.apache.spark.graphx.GraphLoader;
import org.apache.spark.ml.feature.BucketedRandomProjectionLSH;
import org.apache.spark.ml.feature.BucketedRandomProjectionLSHModel;
import org.apache.spark.ml.feature.HashingTF;
import org.apache.spark.sql.*;
import org.apache.spark.sql.catalyst.encoders.RowEncoder;
import org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema;
import org.apache.spark.sql.types.*;
import org.apache.spark.storage.StorageLevel;
import scala.Tuple2;

import java.io.Serializable;
import java.util.*;

public class Main {
    private final static StringEncoder stringEncoder = new Metaphone(); // TODO. Solve problem with Serializable.

    public static void main(final String[] args) {

        // System.setProperty("hadoop.home.dir", "d:\\U\\G1\\T\\spark\\spark-2.1.1-bin-hadoop2.7\\"); // TODO. Calculate in runtime.

        try (SparkSession spark = SparkSession.builder()
                .appName("s-e")
                .master("local[2]")
                .getOrCreate()) {

            spark.sparkContext().setLogLevel("INFO"); // TODO. Calculate in runtime.

            // TODO. Extract data.

            final List<Record> records = Arrays.asList(
                    new Record(0, "Shayna Dalwood", "1990"),
                    new Record(1, "Talya Aysh", "1991"),
                    new Record(2, "Taly Aysh", "1991"),
                    new Record(3, "Aysh Talya ", "1991"),
                    new Record(4, "Bethany Euston", "1989"),
                    new Record(5, "Bethany Eustonn", "1989"),
                    new Record(6, "Bethan Eustonn", "1989"),
                    new Record(7, "Euston Bethany", "1989")
            );

            final List<Row> data = new ArrayList<>();

            records.forEach((Record a) -> {
                try {
                    final String[] rawNames = a.name.split("\\s"); // TODO. Calculate into spark. What about birthday and others?
                    final List<String> calculatedNames = new ArrayList<>();
                    final List<String> parseNames = new ArrayList<>();
                    for (String rName : rawNames) {
                        final String d = stringEncoder.encode(rName);
                        final String[] rawElements = d.split("\\|");
                        Collections.addAll(calculatedNames, rawElements);
                        parseNames.add(rName);
                    }
                    data.add(RowFactory.create(a.key, a.name, a.date, parseNames, calculatedNames));
                } catch (EncoderException e) {
                    throw new RuntimeException(e);
                }
            });

            final StructType schema = new StructType(new StructField[]{
                    new StructField("key", DataTypes.IntegerType, true, Metadata.empty()),
                    new StructField("name", DataTypes.StringType, true, Metadata.empty()),
                    new StructField("date", DataTypes.StringType, true, Metadata.empty()),
                    new StructField("parseNames", new ArrayType(DataTypes.StringType, true), false, Metadata.empty()),
                    new StructField("calculatedNames", new ArrayType(DataTypes.StringType, true), false, Metadata.empty()),
            });

            final Dataset<Row> dataSet = spark.createDataFrame(data, schema);

            new Computer().compute(spark, dataSet);
        }
    }

    private static class Record implements Serializable {
        final int key;
        final String name;
        final String date;

        Record(final int key, final String name, final String date) {
            this.key = key;
            this.name = name;
            this.date = date;
        }
    }

    private static class Computer {
        void compute(final SparkSession spark, final Dataset<Row> dataSet) {

            final HashingTF hashingTF = new HashingTF()
                    .setInputCol("calculatedNames")
                    .setOutputCol("pFeatures")
                    .setNumFeatures(100);

            final Dataset<Row> fData = hashingTF.transform(dataSet);

            final BucketedRandomProjectionLSH mh = new BucketedRandomProjectionLSH() // TODO. Explain. Settings.
                    .setBucketLength(2.0)
                    .setNumHashTables(10)
                    .setInputCol("pFeatures")
                    .setOutputCol("values");

            final BucketedRandomProjectionLSHModel model = mh.fit(fData);

            final Dataset<Row> transformedData = model.transform(fData).cache();

            final Dataset<Row> joinedData =
                    (Dataset<Row>) model.approxSimilarityJoin(transformedData, transformedData, 1.95);

            final StructType newKeysSchema = new StructType(new StructField[]{
                    new StructField("newKey", DataTypes.StringType, true, Metadata.empty()),
                    new StructField("key1", DataTypes.IntegerType, true, Metadata.empty()),
                    new StructField("key2", DataTypes.IntegerType, true, Metadata.empty()),
                    new StructField("distance", DataTypes.DoubleType, false, Metadata.empty()),
            });

            final Dataset<Row> newKeysData = joinedData.map((MapFunction<Row, Row>) row -> {
                final GenericRowWithSchema row1 = row.getAs(0);
                final GenericRowWithSchema row2 = row.getAs(1);
                final double distance = row.getDouble(2);
                final int key1 = row1.getAs(0);
                final int key2 = row2.getAs(0);

                final String newKey = Math.min(key1, key2) + "_" + Math.max(key1, key2);

                return RowFactory.create(newKey, key1, key2, distance);
            }, RowEncoder.apply(newKeysSchema));

            final Dataset<Row> pureKeysData = newKeysData.dropDuplicates("newKey");

            final Dataset<Row> filteredPureKeysData = pureKeysData.filter((FilterFunction<Row>) row -> {
                final int key1 = row.getAs(1);
                final int key2 = row.getAs(2);
                final double distance = row.getDouble(3);

                return distance <= 1.95 && key1 != key2;
            });

            filteredPureKeysData.select("key1", "key2").write().option("delimiter", " ").csv("graph");

            final Graph<Object, Object> graph = GraphLoader.edgeListFile(
                    spark.sparkContext(),
                    "graph",
                    false,
                    -1,
                    StorageLevel.MEMORY_ONLY_SER_2(),
                    StorageLevel.MEMORY_ONLY_SER_2());

            final StructType neighborsSchema = new StructType(new StructField[]{
                    new StructField("nKey", DataTypes.IntegerType, true, Metadata.empty()),
                    new StructField("nKeys", new ArrayType(DataTypes.IntegerType, true), false, Metadata.empty()),
            });

            final JavaRDD<Row> neighborsRows =
                    graph.ops().collectEdges(EdgeDirection.Either()).toJavaRDD().map((Function<Tuple2<Object, Edge<Object>[]>, Row>) t -> {
                        // TODO. Rewrite.
                        final Long key = (Long) t._1;
                        final Set<Integer> keys = new TreeSet<>();
                        for (int i = 0; i < t._2.length; i++) {
                            final Edge<Object> objectEdge = t._2[i];
                            keys.add((int) objectEdge.srcId());
                            keys.add((int) objectEdge.dstId());
                        }
                        return RowFactory.create(key.intValue(), keys.toArray(new Integer[keys.size()]));
                    });

            final Dataset<Row> allKeysData = spark.createDataFrame(neighborsRows, neighborsSchema);

            dataSet.join(allKeysData, dataSet.col("key").equalTo(allKeysData.col("nKey")), "fullouter").show(100);

            // TODO. Save.
        }
    }
}