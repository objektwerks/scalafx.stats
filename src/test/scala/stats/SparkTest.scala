package stats

import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.stat.Statistics._
import org.apache.spark.{SparkConf, SparkContext}
import org.scalatest.FunSuite

class SparkTest extends FunSuite {
  val conf = new SparkConf().setMaster("local[2]").setAppName("stats")
  val context = new SparkContext(conf)

  test("stats") {
    val xs = Vectors.dense(1.0, 2.0, 3.0, 3.0, 4.0, 4.0, 5.0)
    val ys = Vectors.dense(1.5, 2.5, 3.25, 3.5, 4.25, 4.75, 5.5)
    val vectors = context.makeRDD(Seq(xs, ys))
    val summary = colStats(vectors)
    assert(summary.count == 2)
    assert(xs == summary.min)
    assert(ys == summary.max)
    assert(Vectors.dense(1.25,2.25,3.125,3.25,4.125,4.375,5.25) == summary.mean)
    assert(Vectors.dense(0.125,0.125,0.03125,0.125,0.03125,0.28125,0.125) == summary.variance)
  }

  test("correlation") {
    val xs = Vector[Double](1.0, 2.0, 3.0, 3.0, 4.0, 4.0, 5.0)
    val ys = Vector[Double](1.5, 2.5, 3.25, 3.5, 4.25, 4.75, 5.5)
    assert(corr(context.makeRDD(xs), context.makeRDD(ys)) == 0.9919341745639138)
  }
}