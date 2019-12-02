package m.d.s.t.cluster.transformation

import org.apache.spark.rdd.RDD
import org.apache.spark.serializer.KryoSerializer
import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.streaming.dstream.InputDStream
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.scalatest.{Matchers, Outcome}

import scala.collection.mutable

class StreamingMLServiceSuite extends org.scalatest.fixture.FunSuite with Matchers {
  test("simple test") {
    spark =>
      val ssc = new StreamingContext(spark.sparkContext, Seconds(1))

      val service = new StreamingMLService()

      val testData = mutable.Queue[RDD[Row]]()
      val testDStream: InputDStream[Row] = ssc.queueStream(testData)

      service.train(testDStream)

      val predictData = mutable.Queue[RDD[Row]]()
      val predictDStream: InputDStream[Row] = ssc.queueStream(predictData)

      service.predict(predictDStream)

      ssc.start()

      val t1 = spark.sparkContext.makeRDD(Seq(Row(1.0, 0.1, 0.2, 0.3)))
      val t2 = spark.sparkContext.makeRDD(Seq(Row(2.0, 0.0, 0.0, 0.3)))
      val t3 = spark.sparkContext.makeRDD(Seq(Row(3.0, 0.0, 0.2, 0.3)))

      testData += t1
      testData += t2
      testData += t3

      Thread.sleep(2000)

      val d1 = spark.sparkContext.makeRDD(Seq(Row(1.0, 0.1, 0.2, 0.3)))
      val d2 = spark.sparkContext.makeRDD(Seq(Row(2.0, 0.3, 0.1, 0.2)))

      predictData += d1
      predictData += d2

      ssc.awaitTerminationOrTimeout(7000)
  }

  override protected def withFixture(test: OneArgTest): Outcome = {
    val spark: SparkSession =
      SparkSession
        .builder()
        .config("spark.serializer", classOf[KryoSerializer].getName)
        .master("local[4]")
        .getOrCreate()

    try withFixture(test.toNoArgTest(spark))
    finally spark.stop()
  }

  override type FixtureParam = SparkSession
}
