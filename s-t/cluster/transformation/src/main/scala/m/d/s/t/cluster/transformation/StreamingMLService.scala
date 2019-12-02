package m.d.s.t.cluster.transformation

import org.apache.spark.mllib.linalg
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.{LabeledPoint, StreamingLinearRegressionWithSGD}
import org.apache.spark.sql.Row
import org.apache.spark.streaming.dstream.{DStream, InputDStream}

class StreamingMLService {
  var model: StreamingLinearRegressionWithSGD = _

  def train(dataFrame: InputDStream[Row]): Unit = {
    val dataFrameLabeled: DStream[LabeledPoint] =
      dataFrame.map(r => LabeledPoint(r.getDouble(0), Vectors.dense(r.getDouble(1), r.getDouble(2), r.getDouble(3))))

    model = new StreamingLinearRegressionWithSGD()
      .setInitialWeights(Vectors.zeros(3))
      .setNumIterations(2)
      .setStepSize(0.1)
      .setMiniBatchFraction(0.25)

    model.trainOn(dataFrameLabeled)
  }

  def predict(dataFrame: InputDStream[Row]): Unit = {
    val dataFrameLabeled: DStream[(Double, linalg.Vector)] =
      dataFrame.map(r => (r.getDouble(0), Vectors.dense(r.getDouble(1), r.getDouble(2), r.getDouble(3))))

    val r: DStream[(Double, Double)] = model.predictOnValues(dataFrameLabeled)

    r.foreachRDD(d => {
      d.foreach(v => {
        println(v._1 + ": " + v._2)
      })
    })
  }
}
