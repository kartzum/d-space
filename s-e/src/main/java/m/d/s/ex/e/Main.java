package m.d.s.ex.e;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.language.Metaphone;
import org.apache.spark.api.java.function.ForeachFunction;
import org.apache.spark.ml.feature.*;
import org.apache.spark.ml.linalg.SparseVector;
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
                    new Record("Shayna Dalwood", "1990"),
                    new Record("Talya Aysh", "1991"),
                    new Record("Taly Aysh", "1991"),
                    new Record("Aysh Talya ", "1991"),
                    new Record("Bethany Euston", "1989"),
                    new Record("Bethany Eustonn", "1989"),
                    new Record("Euston Bethany", "1989")
            );

            final List<Row> data = new ArrayList<>();

            records.forEach((Record a) -> {
                try {
                    final String[] rawNames = a.name.split("\\s");
                    final List<String> calculatedNames = new ArrayList<>();
                    final List<String> parseNames = new ArrayList<>();
                    for (String rName : rawNames) {
                        final String d = stringEncoder.encode(rName);
                        final String[] rawElements = d.split("\\|");
                        Collections.addAll(calculatedNames, rawElements);
                        parseNames.add(rName);
                    }
                    data.add(RowFactory.create(a.name, a.date, parseNames, calculatedNames));
                } catch (EncoderException e) {
                    throw new RuntimeException(e);
                }
            });

            final StructType schema = new StructType(new StructField[]{
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
        final String name;
        final String date;

        Record(final String name, final String date) {
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

            fData.foreach((ForeachFunction<Row>) row -> {
                final String name = row.getAs("name");
                final SparseVector pFeatures = row.getAs("pFeatures");
                System.out.println(name + " " + pFeatures);
            });
        }
    }
}
