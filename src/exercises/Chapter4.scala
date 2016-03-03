package exercises

object Chapter4 extends App {


}



//
//import java.io.File
//import java.util.Scanner
//import scala.collection.immutable.ListMap
//import scala.io.Source
//
//// Ch4 Exercises
////1. Set up a map of prices for a number of gizmos that you covet. Then
//// produce a second map with the same keys and the prices at a 10 percent discount.
//println("\n\nexercise 1\n\n")
//val wishlist = Map("ipad" -> 700, "macbook" -> 2000, "apartment" -> 1900)
//println(wishlist)
//val discounted = for ((k, v) <- wishlist) yield (k, v*.9)
//println(discounted)
////2. Write a program that reads words from a file. \
//// Use a MUTABLE map to count how often each word appears.
//// To read the words, simply use a java.util.Scanner:
////val in = new java.util.Scanner(new java.io.File("myfile.txt")) while (in.hasNext()) process in.next()
////Or look at Chapter 9 for a Scalaesque  way.
////  At the end, print out all words and their counts.
//println("\n\nexercise 2\n\n")
//println("java approach to file scanning!")
//
//val filepath = "/Users/andrew/Desktop/lorem.txt"
//// java approach
//var in = new Scanner(new File(filepath))
//var wordCount = scala.collection.mutable.Map[String, Int]()
//while (in.hasNext()) {
//val word = in.next()
//wordCount(word) = wordCount.getOrElse(word, 0) + 1
//}
//println("java scanner wordcount")
//println(wordCount)
//// scala approach to reading from file
//println("scala approach to file scanning")
//var in2 = Source.fromFile(filepath, "UTF-8")
//val tokens = in2.mkString.split("\\s+")
//val counts = scala.collection.mutable.Map[String, Int]()
//tokens.foreach { t => counts.getOrElse(t, 0) + 1 }
//println("scala source wordcount")
//println(counts)
//
////3. Repeat the preceding exercise with an immutable map.
//println("\n\nexercise 3\n\n")
//in = new Scanner(new File(filepath))
//var wordCount2 = Map[String, Int]()
//while (in.hasNext()) {
//val word = in.next()
//val count = wordCount2.getOrElse(word, 0)
//wordCount2 = wordCount2 + (word -> (count + 1))
//}
//println("java scanner count w/ immutable map")
//println(wordCount2)
//// 4. Repeat the preceding exercise with a sorted map, so that
//// the words are printed in sorted order.
//
//// build map automatically sorted by key
//in = new Scanner(new File(filepath))
//var scoresByKey = scala.collection.immutable.SortedMap[String, Int]()
//while (in.hasNext) {
//val word = in.next
//val count = scoresByKey.getOrElse(word, 0)
//scoresByKey = scoresByKey + (word -> (count+1))
//}
//println(s"SCORES BY KEY: $scoresByKey")
//print()
//print()
//
//// sort by value
//var scoresByVal = ListMap(scoresByKey.toSeq.sortWith(_._2 > _._2):_*)
//
//println(s"SCORES BY VALUE: $scoresByVal")
//
//
////5. Repeat the preceding exercise with a java.util.TreeMap that you adapt to the Scala API.
//in = new Scanner(new File(filepath))
//scoresByKey = java.util.TreeMap[String, Int]
//while (in.hasNext) {
//val word = in.next
//val count = scoresByKey.getOrElse(word, 0)
//scoresByKey = scoresByKey + (word -> (count+1))
//}
//
//
//
//
//
////6. Define a linked hash map that maps "Monday" to java.util.Calendar.MONDAY, and similarly for the other weekdays. Demonstrate that the elements are visited in insertion order.
////7. Print a table of all Java properties, like this:
////47
////java.runtime.name sun.boot.library.path java.vm.version java.vm.vendor java.vendor.url path.separator java.vm.name
////| Java(TM) SE Runtime Environment
////  | /home/apps/jdk1.6.0_21/jre/lib/i386 | 17.0-b16
////| Sun Microsystems Inc.
////| http://java.sun.com/
////  | :
////  | Java HotSpot(TM) Server VM
////You need to find the length of the longest key before you can print the table.
//
////8. Write a function minmax(values: Array[Int]) that returns a pair containing the smallest and largest values in the array.
//
////9. Write a function lteqgt(values: Array[Int], v: Int) that returns a triple containing the counts of values less than v, equal to v, and greater than v.
//
//
//
////10. What happens when you zip together two strings, such
//// as "Hello".zip("World")? Come up with a plausible use case.
//"Hello".zip("World")
////generates an indexed sequence of vectors. hmm, use cases...