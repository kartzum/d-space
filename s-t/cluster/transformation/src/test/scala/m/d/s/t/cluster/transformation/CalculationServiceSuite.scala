package m.d.s.t.cluster.transformation

import org.apache.spark.serializer.KryoSerializer
import org.apache.spark.sql.SparkSession
import org.scalatest.{Matchers, Outcome}

class CalculationServiceSuite extends org.scalatest.fixture.FunSuite with Matchers {
  test("test 1") {
    spark =>
      assert(CalculationService.run(spark) != null)
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
