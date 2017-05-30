package m.d.s.ex.e;

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

import java.util.*;

public class Main {
    private final static StringEncoder stringEncoder = new Metaphone(); // TODO. Solve problem with Serializable.

    // TODO. Pass parameters. Calculate on cluster.

    public static void main(final String[] args) {
        final String os = System.getProperty("os.name").toLowerCase();
        if (os.startsWith("win")) {
            System.setProperty("hadoop.home.dir", "d:\\U\\G1\\T\\spark\\spark-2.1.1-bin-hadoop2.7\\");
        }

        try (SparkSession spark = SparkSession.builder()
                .appName("s-e")
                .master("local[2]")
                .getOrCreate()) {

            // TODO. Pass through settings.
            spark.sparkContext().setLogLevel("INFO");

            new Computer("data/users.csv", null).compute(spark);
        }
    }

    private static class Computer {
        private final String inputPath;
        private final String outputPath;

        private Computer(final String inputPath, final String outputPath) {
            this.inputPath = inputPath;
            this.outputPath = outputPath;
        }

        void compute(final SparkSession spark) {
            // Read data and prepare. Calculate names.

            final Dataset<Row> initialData =
                    spark.read().option("delimiter", ";").option("header", "true").csv(inputPath);

            final JavaRDD<Row> transformedData = initialData.toJavaRDD().map((Function<Row, Row>) row -> {
                        // TODO. Rewrite. What about birthday and others?
                        final String[] rawNames = row.getString(1).split("\\s");
                        final List<String> calculatedNames = new ArrayList<>();
                        final List<String> parseNames = new ArrayList<>();
                        for (String rName : rawNames) {
                            final String d = stringEncoder.encode(rName);
                            final String[] rawElements = d.split("\\|");
                            Collections.addAll(calculatedNames, rawElements);
                            parseNames.add(rName);
                        }
                        return RowFactory.create(
                                Integer.decode(row.getString(0)),
                                row.getString(1),
                                row.getString(2),
                                parseNames.toArray(new String[parseNames.size()]),
                                calculatedNames.toArray(new String[calculatedNames.size()])
                        );
                    }
            );

            final StructType transformedSchema = new StructType(new StructField[]{
                    new StructField("key", DataTypes.IntegerType, true, Metadata.empty()),
                    new StructField("name", DataTypes.StringType, true, Metadata.empty()),
                    new StructField("date", DataTypes.StringType, true, Metadata.empty()),
                    new StructField("parseNames", new ArrayType(DataTypes.StringType, true), false, Metadata.empty()),
                    new StructField("calculatedNames", new ArrayType(DataTypes.StringType, true), false, Metadata.empty()),
            });

            final Dataset<Row> preparedData = spark.createDataFrame(transformedData, transformedSchema);

            // Calculate hashing.

            // TODO. Explain settings.
            final HashingTF hashingTF = new HashingTF()
                    .setInputCol("calculatedNames")
                    .setOutputCol("pFeatures")
                    .setNumFeatures(100);

            final Dataset<Row> fData = hashingTF.transform(preparedData);

            final BucketedRandomProjectionLSH mh = new BucketedRandomProjectionLSH() // TODO. Explain. Settings.
                    .setBucketLength(2.0)
                    .setNumHashTables(10)
                    .setInputCol("pFeatures")
                    .setOutputCol("values");

            final BucketedRandomProjectionLSHModel model = mh.fit(fData);

            // Join data using similarity. Generate data for finding.

            final Dataset<Row> transformedDataForJoin = model.transform(fData).cache();

            final Dataset<Row> joinedData =
                    (Dataset<Row>) model.approxSimilarityJoin(transformedDataForJoin, transformedDataForJoin, 1.95);

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

            // Filtering.

            final Dataset<Row> filteredPureKeysData = pureKeysData.filter((FilterFunction<Row>) row -> {
                final int key1 = row.getAs(1);
                final int key2 = row.getAs(2);
                final double distance = row.getDouble(3);

                return distance <= 1.95 && key1 != key2;
            });

            // Generate graph for finding neighbors.

            // TODO. Remove old one.
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
                    new StructField("gKey", DataTypes.IntegerType, true, Metadata.empty()),
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
                        final Integer[] nKeys = keys.toArray(new Integer[keys.size()]);
                        return RowFactory.create(key.intValue(), nKeys, Arrays.hashCode(nKeys));
                    });

            final Dataset<Row> allKeysData = spark.createDataFrame(neighborsRows, neighborsSchema);

            // Join data as result.

            final Dataset<Row> resultData = preparedData.join(
                    allKeysData, preparedData.col("key").equalTo(allKeysData.col("nKey")), "fullouter");
            if (outputPath == null) {
                resultData.show(100);
            } else {
                resultData.write().csv(outputPath);
            }
        }
    }
}