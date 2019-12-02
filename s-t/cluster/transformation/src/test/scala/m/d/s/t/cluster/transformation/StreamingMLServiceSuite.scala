package m.d.s.t.cluster.transformation

import org.apache.spark.rdd.RDD
import org.apache.spark.serializer.KryoSerializer
import org.apache.spark.sql.SparkSession
import org.apache.spark.streaming.dstream.InputDStream
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.scalatest.{Matchers, Outcome}

import scala.collection.mutable

class StreamingMLServiceSuite extends org.scalatest.fixture.FunSuite with Matchers {
  test("simple test") {
    spark =>
      val ssc = new StreamingContext(spark.sparkContext, Seconds(1))

      val predictData = mutable.Queue[RDD[String]]()
      val predictDStream: InputDStream[String] = ssc.queueStream(predictData)

      StreamingMLService.predict(predictDStream)

      ssc.start()

      predictData += spark.sparkContext.makeRDD(Seq("a b c d"))
      predictData += spark.sparkContext.makeRDD(Seq("e f"))

      ssc.awaitTerminationOrTimeout(5000)
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
