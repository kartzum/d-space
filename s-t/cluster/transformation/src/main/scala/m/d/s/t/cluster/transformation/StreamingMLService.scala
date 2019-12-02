package m.d.s.t.cluster.transformation

import org.apache.spark.streaming.dstream.InputDStream

object StreamingMLService {
  def predict(dataFrame: InputDStream[String]): Unit = {
    dataFrame.foreachRDD(r => {
      r.foreach(s => {
        println(s)
      })
    })
  }
}
