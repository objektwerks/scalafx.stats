import scala.annotation.tailrec

// P(n, r) exact order of selected r from n
// C(n, r) any order of selected r from n

// C(n, r) = n! / r! (n - r)!

// C(10, 3) = 10! / 3! (10 - 3)!
//            10! / 3! (7)!
//            10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1
//         /  (3 * 2 * 1) * (7 * 6 * 5 * 4 * 3 * 2 * 1)
// Remove common dividend and divisor factorial numbers
//            10 * 9 * 8 / 3 * 2 * 1
//            720 / 6
// C(10, 3) = 120

// P(n, r) = n! / (n - r)!

// expected value: mean of a discrete random variable: sum(x)P(x)
// variance: variance of discrete random variable: sum(x - u)2P(x)

//

@tailrec
def factorial(n: Long, acc: Long = 1): Long = n match {
  case i if i <= 0 => acc
  case _ => factorial(n - 1, acc * n)
}

def combinations(n: Int, r: Int): Long = {
  val dividend = factorial(n)
  val divisor = factorial(r) * factorial(n - r)
  dividend / divisor
}

def permutations(n: Int, r: Int): Long = {
  val dividend = factorial(n)
  val divisor = factorial(n - r)
  dividend / divisor
}

def probability(outcomeToCount: Vector[(Double, Double)]): Vector[Double] = {
  val countTotal = outcomeToCount.map(t => t._2).sum
  outcomeToCount.map(t => t._2 / countTotal)
}

def expectedValue(outcomeToCount: Vector[(Double, Double)]): Double = {
  val countTotal = outcomeToCount.map(t => t._2).sum
  outcomeToCount.map(t => t._1 * (t._2 / countTotal)).sum
}

val f = factorial(9)
val c = combinations(10, 3)   // 10 choose 3
val p = permutations(10, 3)

val outcomesToCount = Vector((1.0, 5.0), (2.0, 10.0), (3.0, 11.0), (4.0, 44.0), (5.0, 38.0))
val prob = probability(outcomesToCount)
val ev = expectedValue(outcomesToCount)
