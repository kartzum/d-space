package m.d.s.ex.e;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.language.Metaphone;
import org.apache.spark.ml.feature.*;
import org.apache.spark.sql.*;
import org.apache.spark.sql.types.*;

import java.io.Serializable;
import java.util.*;

public class Main {
    private final static StringEncoder stringEncoder = new Metaphone(); // TODO. Solve problem with Serializable.

    public static void main(final String[] args) {

        try (SparkSession spark = SparkSession.builder()
                .appName("s-e")
                .master("local[2]")
                .getOrCreate()) {

            // TODO. Extract data.

            final List<Record> records = Arrays.asList(
                    new Record("0", "Shayna Dalwood", "1990"),
                    new Record("1", "Talya Aysh", "1991"),
                    new Record("2", "Taly Aysh", "1991"),
                    new Record("3", "Aysh Talya ", "1991"),
                    new Record("4", "Bethany Euston", "1989"),
                    new Record("5", "Bethany Eustonn", "1989"),
                    new Record("6", "Euston Bethany", "1989")
            );

            final List<Row> data = new ArrayList<>();

            records.forEach((Record a) -> {
                try {
                    final String[] rawNames = a.name.split("\\s"); // TODO. Calculate into spark. And bday.
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
                    new StructField("key", DataTypes.StringType, true, Metadata.empty()),
                    new StructField("name", DataTypes.StringType, true, Metadata.empty()),
                    new StructField("date", DataTypes.StringType, true, Metadata.empty()),
                    new StructField("parseNames", new ArrayType(DataTypes.StringType, true), false, Metadata.empty()),
                    new StructField("calculatedNames", new ArrayType(DataTypes.StringType, true), false, Metadata.empty()),
            });

            final Dataset<Row> dataSet = spark.createDataFrame(data, schema);

            new Computer().compute(dataSet);
        }
    }

    private static class Record implements Serializable {
        final String key;
        final String name;
        final String date;

        Record(final String key, final String name, final String date) {
            this.key = key;
            this.name = name;
            this.date = date;
        }
    }

    private static class Computer {
        void compute(final Dataset<Row> dataSet) {

            final HashingTF hashingTF = new HashingTF()
                    .setInputCol("calculatedNames")
                    .setOutputCol("pFeatures")
                    .setNumFeatures(30);

            final Dataset<Row> fData = hashingTF.transform(dataSet);

            final BucketedRandomProjectionLSH mh = new BucketedRandomProjectionLSH()
                    .setBucketLength(2.0)
                    .setNumHashTables(3)
                    .setInputCol("pFeatures")
                    .setOutputCol("values");

            final BucketedRandomProjectionLSHModel model = mh.fit(fData);

            final Dataset<Row> transformedData = model.transform(fData).cache();

            model.approxSimilarityJoin(transformedData, transformedData, 1.95).show();
        }
    }
}
