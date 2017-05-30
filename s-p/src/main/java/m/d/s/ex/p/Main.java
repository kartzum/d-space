package m.d.s.ex.p;

import java.util.Arrays;
import java.util.List;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.ml.feature.BucketedRandomProjectionLSH;
import org.apache.spark.ml.feature.BucketedRandomProjectionLSHModel;
import org.apache.spark.ml.linalg.Vector;
import org.apache.spark.ml.linalg.Vectors;
import org.apache.spark.ml.linalg.VectorUDT;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.Metadata;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import org.apache.spark.sql.*;

public class Main {
    public static void main(final String[] args) {

        try (SparkSession spark = SparkSession.builder()
                .appName("s-p")
                .master("local[2]")
                .getOrCreate()) {
            // new BucketedRandomProjectionLSHComputer().compute(spark);
            new CsvComputer().compute(spark);
        }
    }

    private static abstract class Computer {
        abstract void compute(final SparkSession spark);
    }

    private static class BucketedRandomProjectionLSHComputer extends Computer {

        @Override
        void compute(final SparkSession spark) {
            final List<Row> dataA = Arrays.asList(
                    RowFactory.create(0, Vectors.dense(1.0, 1.0)),
                    RowFactory.create(1, Vectors.dense(1.0, -1.0)),
                    RowFactory.create(2, Vectors.dense(-1.0, -1.0)),
                    RowFactory.create(3, Vectors.dense(-1.0, 1.0))
            );

            final List<Row> dataB = Arrays.asList(
                    RowFactory.create(4, Vectors.dense(1.0, 0.0)),
                    RowFactory.create(5, Vectors.dense(-1.0, 0.0)),
                    RowFactory.create(6, Vectors.dense(0.0, 1.0)),
                    RowFactory.create(7, Vectors.dense(0.0, -1.0))
            );

            final StructType schema = new StructType(new StructField[]{
                    new StructField("id", DataTypes.IntegerType, false, Metadata.empty()),
                    new StructField("keys", new VectorUDT(), false, Metadata.empty())
            });
            final Dataset<Row> dfA = spark.createDataFrame(dataA, schema);
            final Dataset<Row> dfB = spark.createDataFrame(dataB, schema);

            final BucketedRandomProjectionLSH mh = new BucketedRandomProjectionLSH()
                    .setBucketLength(2.0)
                    .setNumHashTables(3)
                    .setInputCol("keys")
                    .setOutputCol("values");

            final BucketedRandomProjectionLSHModel model = mh.fit(dfA);

            // Feature Transformation
            model.transform(dfA).show();
            // Cache the transformed columns
            final Dataset<Row> transformedA = model.transform(dfA).cache();
            final Dataset<Row> transformedB = model.transform(dfB).cache();

            // Approximate similarity join
            model.approxSimilarityJoin(dfA, dfB, 1.5).show();
            model.approxSimilarityJoin(transformedA, transformedB, 1.5).show();

            // Self Join
            model.approxSimilarityJoin(dfA, dfA, 2.5).filter("datasetA.id < datasetB.id").show();

            final Vector key = Vectors.dense(1.0, 0.0);

            // Approximate nearest neighbor search
            model.approxNearestNeighbors(dfA, key, 2).show();
            model.approxNearestNeighbors(transformedA, key, 2).show();
        }
    }

    private static class CsvComputer extends Computer {
        @Override
        void compute(final SparkSession spark) {
            final Dataset<Row> usersData =
                    spark.read().option("delimiter", ";").option("header", "true").csv("data/users.csv");

            final JavaRDD<Row> transformedUsersData = usersData.toJavaRDD().map((Function<Row, Row>) row ->
                    RowFactory.create(Integer.decode(row.getString(0)), row.getString(1), row.getString(2)));

            final StructType schema = new StructType(new StructField[]{
                    new StructField("key", DataTypes.IntegerType, true, Metadata.empty()),
                    new StructField("name", DataTypes.StringType, true, Metadata.empty()),
                    new StructField("birthday", DataTypes.StringType, true, Metadata.empty()),
            });

            spark.createDataFrame(transformedUsersData, schema).show();
        }
    }
}
