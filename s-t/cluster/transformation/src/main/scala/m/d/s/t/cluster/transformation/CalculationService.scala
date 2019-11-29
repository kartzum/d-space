package m.d.s.t.cluster.transformation

import org.apache.spark.sql.{DataFrame, SparkSession}

object CalculationService {
  def run(spark: SparkSession): DataFrame = {
    spark.emptyDataFrame
  }
}
