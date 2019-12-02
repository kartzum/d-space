# s-t

## Links
* [kafka](https://kafka.apache.org/quickstart)
* [Testing strategy for Spark Streaming - Part 2 of 2](https://blog.ippon.tech/testing-strategy-for-spark-streaming/)
* [Spark and Spark Streaming Unit Testing](http://mkuthan.github.io/blog/2015/03/01/spark-unit-testing/)

## Real Time Analytics (links and notes)
* [RegressionStreaming](https://github.com/PacktPublishing/Apache-Spark-2-Data-Processing-and-Real-Time-Analytics/blob/master/Module_3/Chapter%2016/Chapter%2016%20Code/RegressionStreaming.scala)
* [Apache Spark 2: Data Processing and Real-Time Analytics](https://www.packtpub.com/big-data-and-business-intelligence/apache-spark-2-data-processing-and-real-time-analytics)
* [Hands-On Data Analysis with Scala](https://github.com/PacktPublishing/Hands-On-Data-Analysis-with-Scala)
* [Hands-On Data Analysis with Scala](https://www.packtpub.com/big-data-and-business-intelligence/hands-data-analysis-scala)
* [StreamingLogisticRegression.scala](https://github.com/apache/spark/blob/master/examples/src/main/scala/org/apache/spark/examples/mllib/StreamingLogisticRegression.scala)
* [movie-recommendation-with-mllib](http://ampcamp.berkeley.edu/big-data-mini-course/movie-recommendation-with-mllib.html)

## Notes

```
https://kafka.apache.org/quickstart

https://www.apache.org/dyn/closer.cgi?path=/kafka/2.3.0/kafka_2.12-2.3.0.tgz
tar -xzf kafka_2.12-2.3.0.tgz
cd kafka_2.12-2.3.0

bin/zookeeper-server-start.sh config/zookeeper.properties
bin/kafka-server-start.sh config/server.properties

bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic test
bin/kafka-topics.sh --list --bootstrap-server localhost:9092

bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning
```

```
https://www.tutorialspoint.com/apache_kafka/apache_kafka_simple_producer_example.htm
```

```
import java.util.Properties;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class SimpleProducer {

   public static void main(String[] args) throws Exception{

      // Check arguments length value
      if(args.length == 0){
         System.out.println("Enter topic name");
         return;
      }

      //Assign topicName to string variable
      String topicName = args[0].toString();

      // create instance for properties to access producer configs
      Properties props = new Properties();

      //Assign localhost id
      props.put("bootstrap.servers", "localhost:9192");

      //Set acknowledgements for producer requests.
      props.put("acks", "all");

      //If the request fails, the producer can automatically retry,
      props.put("retries", 0);

      //Specify buffer size in config
      props.put("batch.size", 16384);

      //Reduce the no of requests less than 0
      props.put("linger.ms", 1);

      //The buffer.memory controls the total amount of memory available to the producer for buffering.
      props.put("buffer.memory", 33554432);

      props.put("key.serializer",
         "org.apache.kafka.common.serialization.StringSerializer");

      props.put("value.serializer",
         "org.apache.kafka.common.serialization.StringSerializer");

      Producer<String, String> producer = new KafkaProducer
         <String, String>(props);

      for(int i = 0; i < 10; i++)
         producer.send(new ProducerRecord<String, String>(topicName,
            Integer.toString(i), Integer.toString(i)));
               System.out.println("Message sent successfully");
               producer.close();
   }
}
```

```
javac -cp "/data/home/akoval/pr/k/1/kafka_2.12-2.3.0/libs/*" SimpleProducer.java
java -cp "/data/home/akoval/pr/k/1/kafka_2.12-2.3.0/libs/*":. SimpleProducer test
```
