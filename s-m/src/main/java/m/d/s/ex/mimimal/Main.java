package m.d.s.ex.mimimal;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.SparkConf;
import scala.Tuple2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        final SparkConf conf = new SparkConf().setMaster("local").setAppName("Minimal");
        try (JavaSparkContext sc = new JavaSparkContext(conf)) {
            final JavaRDD<String> textFile = sc.textFile("s-m/src/main/resources/data.txt");
            final JavaPairRDD<String, Integer> counts = textFile
                    .flatMap(s -> Arrays.asList(s.split("[ ,]")).iterator())
                    .mapToPair(word -> new Tuple2<>(word, 1))
                    .reduceByKey((a, b) -> a + b);
            counts.foreach(p -> System.out.println(p));
            System.out.println("Total words: " + counts.count());
        }
    }
}
