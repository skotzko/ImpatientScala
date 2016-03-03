package exercises

import collection.mutable
import util.Random

object Chapter3 extends App {
  //  1
  def randArray(n: Int) = {
    (for (i <- 1 to n) yield Random.nextInt).toArray
  }

  println("\n\nExercise 1")
  var a = randArray(10)
  println(a.toList)


  //  2
  def swap(arr: Array[Int]) = {
    for (i <- 0 until(if (arr.length % 2 == 0) arr.length else arr.length - 1, 2)) {
      val swap = arr(i)
      arr(i) = arr(i + 1)
      arr(i + 1) = swap
    }
    arr
  }

  println("\n\nExercise 2")
  a = Array(1, 2, 3, 4, 5)
  println(swap(a).toList)


  // 3
  def swap2(arr: Array[Int]) = {
    (for (i <- arr.indices) yield {
      if (i == arr.length - 1 & i % 2 == 0) // on last item and odd length array
        arr(i)
      else if (i % 2 == 0)
        arr(i + 1)
      else
        arr(i - 1)
    }).toArray
  }

  println("\n\nExercise 3")
  a = Array(1, 2, 3, 4, 5)
  println(swap2(a).toList)
  println()


  // 4
  def positiveThenNeg(arr: Array[Int]) = {
    Array.concat(for (i <- arr if i > 0) yield i, for (i <- arr if i <= 0) yield i)
  }

  println("\n\nExercise 4")
  a = Array(0, -1, 2, 4, 3, -2, 0)
  println(positiveThenNeg(a).toList)

  // 5
  var doubles = Array(0.3, 1.4, 6.5, 11.2, 3.1)

  println("\n\nExercise 5")
  print(doubles.sum / doubles.length)


  // 6
  println("\n\nExercise 6")

  // sort array
  println("\nARRAY SORTING")
  a = randArray(10)
  var aClone = a.clone // make clone so we can use original a later
  print("original array: ")
  println(a.toList)

  print("sorted array: ")
  util.Sorting.quickSort(aClone)
  println(aClone.toList)

  print("reversed array: ")
  aClone = aClone.reverse
  println(aClone.toList)


  // sort as buffer
  println("\n\nBUFFER SORTING")
  var b = a.toBuffer
  print("original buffer: ")
  println(b)

  print("reversed buffer: ")
  b.sortWith(_ > _)
  println(b)


  //  7
  println("\n\nExercise 7")
  a = Array(1, 1, 2, 2, 3, 8, 28, 3, 68, 872, 4)
  println(a.toList)
  println(a.distinct.toList)


  // 8
  println("\n\nExercise 8")
  val ab = Array(1, 2, -9, -28, 234, 829, 4, 13, -12, 11).toBuffer
  println(ab.mkString(", "))
  val idx = (for (i <- ab.indices if ab(i) < 0) yield i).reverse.dropRight(1)
  val finalArray = for (i <- idx) ab.remove(i)
  println(ab.mkString(", "))


  // 9
  println("\n\nExercise 9")
  var zones = java.util.TimeZone.getAvailableIDs
                                .filter(_.startsWith("America/"))
                                .map(_.stripPrefix("America/"))
                                .toBuffer.sortWith(_ > _) // reverse sorting it as a buffer, just because I can.
  println(zones)


  // 10
  println("\n\nExercise 10")
  import java.awt.datatransfer._
  val flavors = SystemFlavorMap.getDefaultFlavorMap.asInstanceOf[SystemFlavorMap]
  var result = collection.JavaConversions.asScalaBuffer(flavors.getNativesForFlavor(DataFlavor.imageFlavor))
  println(result)

}