object Chapter2 extends App {

  // 1
  def signum(n: Int) = {
    if (n < 0) -1 else if (n == 0) 0 else 1
  }

  //  2
  //  type is 'Unit' and value is () (AKA "no useful value")

  //  3


  //  4
  for (i <- 0 to 10; out = 10 - i) println(out)
  println()
  for (i <- 10 to 0 by -1) println(i)


  //  5
  def countdown(n: Int) {
    if (n > 0)
      for (i <- n to 0 by -1) println(i)
    else
      for (i <- n to 0) println(i)
  }


  //  6
  {
    var prod = 1
    for (i <- "Hello") prod *= i.toInt
    println(s"product of the Unicode values in 'Hello' is $prod")
    println()
  }

  //  7
  {
    var prod = 1
    "Hello".foreach((c: Char) => prod *= c)
    println(s"product of the Unicode values in 'Hello' is $prod")
    println()
  }

  //  8
  {
    def product(s: String) = {
      var product = 1
      for (i <- s) product *= i.toInt
      product
    }

    println(product("Hello"))
    println()
  }

  //  9
  {
    def product(s: String): Int = {
      val tail = s.tail
      s.head * (if (tail.size == 0) 1 else product(tail))
    }

    println(product("Hello"))
    println()
  }


  // 10
  def intPow(x: Double, n: Int): Double = {
    if (n > 0 & n % 2 == 0) math.pow(intPow(x, n >> 1), 2)
    else if (n > 0) x * intPow(x, n - 1)
    else if (n == 0) 1
    else 1 / intPow(x, -n) // (n < 0)
  }

}