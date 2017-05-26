package m.d.s.ex.e;

import org.apache.commons.codec.language.bm.BeiderMorseEncoder;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.Function;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Main {
    final static BeiderMorseEncoder beiderMorseEncoder = new BeiderMorseEncoder(); // TODO. Solve problem with Serializable.

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
            final JavaRDD<Record> source = sc.parallelize(records); // TODO. Read data from remote source.
            final Executor executor = new Executor();
            executor.execute(source);
        }
    }

    private static class Executor {
        void execute(final JavaRDD<Record> source) {
            source.map((Function<Record, RecordEx>) record -> {
                final String data = beiderMorseEncoder.encode(record.name);
                final RecordEx result = new RecordEx(record.name, record.date, data);
                System.out.println(result);
                return result;
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
    }

    private static class RecordEx implements Serializable {
        final String name;
        final String date;
        final String data;

        RecordEx(final String name, final String date, final String data) {
            this.name = name;
            this.date = date;
            this.data = data;
        }

        @Override
        public String toString() {
            return "RecordEx{" +
                    "name='" + name + '\'' +
                    ", date='" + date + '\'' +
                    ", data='" + data + '\'' +
                    '}';
        }
    }
}
