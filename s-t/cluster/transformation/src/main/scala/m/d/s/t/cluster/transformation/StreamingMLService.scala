package m.d.s.t.cluster.transformation

import org.apache.spark.sql.Row
import org.apache.spark.streaming.dstream.InputDStream

class StreamingMLService {
  def predict(dataFrame: InputDStream[Row]): Unit = {
    dataFrame.foreachRDD(r => {
      r.foreach(s => {
        println(s)
      })
    })
  }
}
