package stats

import breeze.linalg.DenseVector
import breeze.stats._
import org.scalatest.FunSuite

class BreezeTest extends FunSuite {
  val xs = DenseVector[Double](1.0, 2.0, 3.0, 3.0, 4.0, 4.0, 5.0)
  val ys = DenseVector[Double](1.5, 2.5, 3.25, 3.5, 4.25, 4.75, 5.5)

  test("stats") {
    assert((22.0, 7) == accumulateAndCount(xs))
    assert(mean(xs) == 3.142857142857143)
    assert(median(xs) == 3.0)
    assert(variance(xs) == 1.8095238095238093)
    assert(stddev(xs) == 1.3451854182690985)
  }
}