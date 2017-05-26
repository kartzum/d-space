package m.d.s.ex.e;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.Function;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(final String[] args) {
        final SparkConf conf = new SparkConf().setMaster("local").setAppName("e");
        try (JavaSparkContext sc = new JavaSparkContext(conf)) {
            final List<Record> records = Arrays.asList(
                    new Record("Shayna Dalwood", "1990"),
                    new Record("Talya Aysh", "1991"),
                    new Record("Taly Aysh", "1991"),
                    new Record("Bethany Euston", "1989"),
                    new Record("Bethany Eustonn", "1989")
            );
            final JavaRDD<Record> source = sc.parallelize(records);
            final Executor executor = new Executor();
            executor.execute(source);
        }
    }

    private static class Executor {
        void execute(final JavaRDD<Record> source) {
            source.map((Function<Record, Record>) record -> {
                System.out.println(record);
                return record;
            }).count();
        }
    }

    private static class Record implements Serializable {
        final String name;
        final String date;

        Record(final String name, final String date) {
            this.name = name;
            this.date = date;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            final Record record = (Record) o;

            return name.equals(record.name) && date.equals(record.date);
        }

        @Override
        public int hashCode() {
            int result = name.hashCode();
            result = 31 * result + date.hashCode();
            return result;
        }

        @Override
        public String toString() {
            return "Record{" +
                    "name='" + name + '\'' +
                    ", date='" + date + '\'' +
                    '}';
        }
    }
}
