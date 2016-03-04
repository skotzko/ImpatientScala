package exercises

import java.io.File
import java.util.Scanner
import scala.collection.immutable.{HashMap, ListMap}
import io.Source

object Chapter4 extends App {

  // 1
  println("\n\nExercise 1")
  val wishlist = Map(
    "ipad" -> 700,
    "macbook" -> 2000,
    "new apartment" -> 1900
  )
  val discounted = for ((k, v) <- wishlist) yield (k, v * .9)

  println(discounted)

  // 2
  println("\n\nExercise 2")

  val in = Source.fromFile("files/lorem.txt", "UTF-8")
  val tokens = in.mkString.split("\\s+")

  val counts = scala.collection.mutable.Map[String, Int]()
  tokens.foreach(t => counts(t) = counts.getOrElse(t, 0) + 1)
  println(counts)

  // 3
  println("\n\nExercise 3")
  var counts2 = Map[String, Int]()
  tokens.foreach { t =>
    counts2 = counts2 + (t -> (counts2.getOrElse(t, 0) + 1))
  }
  println(counts2)

  print("Counts equal? ")
  print(counts == counts2)

  // 4
  {
    var scoresByKey = collection.immutable.SortedMap[String, Int]()
    tokens.foreach { t =>
      val count = scoresByKey.getOrElse(t, 0)
      scoresByKey = scoresByKey + (t -> (count + 1))
    }

    println(scoresByKey)

    //  sort by value (descending)
    val scoresByVal = ListMap(scoresByKey.toSeq.sortWith(_._2 > _._2): _*)
  }


  //  5
  println("\n\nExercise 5")

  {
    val scoresByKey = java.util.TreeMap[String, Int]
    tokens.foreach {t =>
      val count = scoresByKey.
      scoresByKey = scoresByKey + (t -> (count + 1))
    }
  }

  //
  //  //5. Repeat the preceding exercise with a java.util.TreeMap that you adapt to the Scala API.
  //  in = new Scanner(new File(filepath))
  //  scoresByKey = java.util.TreeMap[String, Int]
  //  while (in.hasNext) {
  //    val word = in.next
  //    val count = scoresByKey.getOrElse(word, 0)
  //    scoresByKey = scoresByKey + (word -> (count + 1))
  //  }
  //
  //
  //
  //
  //
  //  //6. Define a linked hash map that maps "Monday" to java.util.Calendar.MONDAY, and similarly for the other weekdays
  //  // . Demonstrate that the elements are visited in insertion order.
  //  //7. Print a table of all Java properties, like this:
  //  //47
  //  //java.runtime.name sun.boot.library.path java.vm.version java.vm.vendor java.vendor.url path.separator java.vm.name
  //  //| Java(TM) SE Runtime Environment
  //  //  | /home/apps/jdk1.6.0_21/jre/lib/i386 | 17.0-b16
  //  //| Sun Microsystems Inc.
  //  //| http://java.sun.com/
  //  //  | :
  //  //  | Java HotSpot(TM) Server VM
  //  //You need to find the length of the longest key before you can print the table.
  //
  //  //8. Write a function minmax(values: Array[Int]) that returns a pair containing the smallest and largest values in
  //  // the array.
  //
  //  //9. Write a function lteqgt(values: Array[Int], v: Int) that returns a triple containing the counts of values less
  //  // than v, equal to v, and greater than v.
  //
  //
  //  //10. What happens when you zip together two strings, such
  //  // as "Hello".zip("World")? Come up with a plausible use case.
  //  "Hello".zip("World")
  //  //generates an indexed sequence of vectors. hmm, use cases...

}