package exercises

object Chapter3 extends App {


}



//// CHAPTER 3
//// 1. Write a code snippet that sets a to an array of n random integers between 0 (inclusive) and n (exclusive).
//import scala.collection.mutable
//import util.Random
//def randomArray(n: Int) = {
//  val a = new Array[Int](n)
//  for (i <- 0 until a.size) a(i) = Random.nextInt(n)
//  a
//}
//
//// 2. Write a loop that swaps adjacent elements of an array of integers. For example, Array(1, 2, 3, 4, 5) becomes Array(2, 1, 4, 3, 5).
//// if index %2 != 0 then ignore it
//// loop thru, if
//val upper = 10
//val a = randomArray(upper)
//// do w/ filter and map instead
//
//// mistake I made here: forgetting that 0 index would pass the test
//def swapper(arr: Array[Int]) = {
//  for (i <- 0 until (if (arr.length % 2 == 0) arr.length else arr.length - 1, 2)) {
//    val swap = arr(i)
//    arr(i) = arr(i + 1)
//    arr(i + 1) = swap
//  }
//  arr
//}
//
//// 3. Repeat the preceding assignment, but produce a new array with the swapped values. Use   \\for/yield.
////   yield if (i == arr.length - 1 & i % 2 == 0) arr(i) else if (i % 2 == 0) arr(i + 1) else arr(i - 1)).toArray
//def newSwapper(arr: Array[Int]) = {
//  (for( i <- 0 until arr.length) yield {
//    if (i == arr.length - 1 & i % 2 == 0) // on last item and it's odd length array
//      arr(i)
//    else if (i % 2 == 0)
//      arr(i + 1)
//    else
//      arr(i - 1)
//  }).toArray
//}
//
//// 4. Given an array of integers, produce a new array that contains all positive values of the original array, in their original order, followed by all values that are zero or negative, in their original order.
//var arr = (1 to 5).toArray
//// collect indexes of zero/negative items
//val indexes = for( i <- 0 until arr.length if arr(i) <= 0) yield i
//for( i <- 0 until arr.length) yield {
//  // collect indexes, then yield them at the end
//  if (arr(i) > 0 ) arr(i)
//  // now add zero/negative items back
//}
//
//// 5. How do you compute the average of an Array[Double]?
//// sum / number of elements
//val avg = Array(1.0, 3.0, 5.0)
//println(avg.sum / avg.length)
//
//// 6. How do you rearrange the elements of an Array[Int] so that they appear in
//// reverse sorted order? How do you do the same with an ArrayBuffer[Int]?
//val a2 = randomArray(10)
//val b = a2.toBuffer
//
//a2.sorted.reverse
//b.sorted.reverse
//
//a2.sortWith(_ > _)
//b.sortWith(_ > _)
//
//
//// 7. Write a code snippet that produces all values from an array with duplicates
//// removed. (Hint: Look at Scaladoc.)
//val a3 = randomArray(10)
//a3.distinct
//
//// 8. Rewrite the example at the end of Section 3.4, “Transforming Arrays,” on page 32. Collect indexes of the negative elements, reverse the sequence, drop the last index, and call a.remove(i) for each index. Compare the efficiency of this approach with the two approaches in Section 3.4.
//val a4 = Array(1,2,-9,-28,234,829,4,13,-12,11).toBuffer
//val indexes2 = (for( i <- 0 until a4.length if a4(i) < 0) yield i).reverse.dropRight(1)
//val finalArray = for( i <- indexes) a4.remove(i)
//println(a4.mkString(", "))
//
//// 9. Make a collection of all time zones returned by java.util.TimeZone.getAvailableIDs that are in America. Strip off the "America/" prefix and sort the result.
//val zones = java.util.TimeZone.getAvailableIDs
//val american = zones.filter(_.startsWith("America/")).map(_.drop("America/".size))
//
//
//// 10. Import java.awt.datatransfer._ and make an object of type SystemFlavorMap with the call
//// val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
//// Then call the getNativesForFlavor method with parameter DataFlavor.imageFlavor and get the return value as a Scala buffer. (Why this obscure class? It’s hard to find uses of java.util.List in the standard Java library.)
//import java.awt.datatransfer._
////val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
////val res: mutable.Buffer[String] = flavors.getNativesForFlavor(DataFlavor.imageFlavor)
