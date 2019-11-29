package m.d.s.t.cluster.transformation

import org.apache.spark.serializer.KryoSerializer
import org.apache.spark.sql.SparkSession

object Runner {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder()
      .enableHiveSupport()
      .config("hive.exec.local.scratchdir", "/tmp/hive/scratchdirectory")
      .config("spark.serializer", classOf[KryoSerializer].getName)
      .appName("_")
      .getOrCreate()

    try {
      CalculationService.run(spark)
    }
    finally {
      spark.stop()
    }
  }
}
