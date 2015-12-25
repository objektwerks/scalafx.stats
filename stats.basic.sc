import scala.collection.immutable.{SortedMap, TreeMap}

def mean(xs: Vector[Double]): Double = {
  require(xs.nonEmpty, "Nonempty vector required.")
  xs.sum / xs.length
}

def median(xs: Vector[Double]): Double = {
  require(xs.nonEmpty, "Nonempty vector required.")
  xs( xs.length / 2 )
}

def mode(xs: Vector[Double]): Vector[Double] = {
  val hg = histogram(xs)
  val max = hg.values.max
  hg.filter(_._2 == max).keys.to[Vector]
}

def range(xs: Vector[Double]): Double = {
  require(xs.nonEmpty, "Nonempty vector required.")
  xs.max - xs.min
}

def histogram(xs: Vector[Double]): SortedMap[Double, Int] = {
  require(xs.nonEmpty, "Nonempty vector required.")
  TreeMap[Double, Int]() ++ xs.groupBy(x => x).mapValues(_.length)
}

def variance(xs: Vector[Double]): Double = {
  require(xs.nonEmpty, "Nonempty vector required.")
  val m = mean(xs)
  xs.iterator.map(x => math.pow(x - m, 2.0)).sum / (xs.length - 1)
}

def standardDeviation(xs: Vector[Double]): Double = {
  require(xs.nonEmpty, "Nonempty vector required.")
  math.sqrt( variance(xs) )
}

def standardError(xs: Vector[Double]): Double = {
  standardDeviation(xs) / math.sqrt(xs.length)
}

def covariance(xs: Vector[Double], ys: Vector[Double]): Double = {
  val xsm = mean(xs)
  val ysm = mean(ys)
  xs.zip(ys).map(t => (t._1 - xsm) * (t._2 - ysm)).sum / (xs.length - 1)
}

def correlationCoefficient(xs: Vector[Double], ys: Vector[Double]): Double = {
  val xsm = mean(xs)
  val ysm = mean(ys)
  val xssd = standardDeviation(xs)
  val yssd = standardDeviation(ys)
  val xsys = xs.zip(ys).map(t => (t._1 - xsm) * (t._2 - ysm)).sum
  (xsys / (xssd * yssd)) / (xs.length - 1)
}

val es = Vector[Double]()
val xs = Vector[Double](1.0, 2.0, 3.0, 3.0, 4.0, 4.0, 5.0)
val ys = Vector[Double](1.5, 2.5, 3.25, 3.5, 4.25, 4.75, 5.5)

val _mean = mean(xs)
val _median = median(xs)
val _mode = mode(xs)
val _range = range(xs)
val _histogram = histogram(xs)
val _variance = variance(xs)
val _standard_deviation = standardDeviation(xs)
val _standard_error = standardError(xs)
val _covariance = covariance(xs, ys)
val _correlation_coefficient= correlationCoefficient(xs, ys)

val x = Vector(3.0, 3.0, 6.0)
val y = Vector(2.0, 3.0, 4.0)
val xm = mean(x)
val ym = mean(y)
val xsd = standardDeviation(x)
val ysd = standardDeviation(y)
val xy = x.zip(y).map(t => (t._1 - xm) * (t._2 - ym)).sum
val c = (xy / (xsd * ysd)) / (x.length - 1)
val cc = correlationCoefficient(x, y)