import BigInt.probablePrime
import util.Random

object Chapter1 extends App {

  //  1 - just do it in REPL

  //  2
  println(3 - math.pow(math.sqrt(3), 2))

  //  3
  //  res variables are vals

  //  4
  println("crazy" * 3)

  //  5
  println(10 max 2)


  //  6
  println(BigInt(2) pow(1024))

  //  7
  // must import: scala.math.BigInt.probablePrime & scala.util.Random
  probablePrime(100, Random)

  //  8
  // get random BigInt & convert to base36
  BigInt(100, Random).toString(36)

  //  9
  var name = "andrew"
  println(name(0) + " " + name.last)

  //  10
  println("andrew" take 3, "andrew" drop 3, "andrew" takeRight 3, "andrew" dropRight 3)

}