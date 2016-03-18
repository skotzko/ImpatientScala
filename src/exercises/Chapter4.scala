import scala.collection.immutable.ListMap
import io.Source
import scala.collection.mutable

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
  println("\n\nExercise 4")

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
    import collection.convert.wrapAsScala.mapAsScalaMap
    var scoresByKey = new java.util.TreeMap[String, Int]
    tokens.foreach { t =>
      val count = scoresByKey.getOrElse(t, 0)
      scoresByKey += t -> (count + 1)
    }

    println(scoresByKey)
  }

  //  6
  println("\n\nExercise 6")

  {
    import java.util.Calendar._

    val days = mutable.LinkedHashMap[String, Int](
      "Monday" -> MONDAY,
      "Tuesday" -> TUESDAY,
      "Wednesday" -> WEDNESDAY,
      "Thursday" -> THURSDAY,
      "Friday" -> FRIDAY,
      "Saturday" -> SATURDAY,
      "Sunday" -> SUNDAY
    )

    days.foreach(println)

  }

  // 7
  println("\n\nExercise 7")

  {
    import collection.convert.wrapAsScala._
    val props = propertiesAsScalaMap(System.getProperties)
    val maxKeyLength = props.keySet.map(_.size).max
    for ((k, v) <- props) printf("%-" + maxKeyLength + "s | %s\n", k, v)
  }


  // 8
  println("\n\nExercise 8")

  def minMax(values: Array[Int]) = (values.min, values.max)

  println(minMax(Array(2,1,-2,9,12)))


  // 9
  println("\n\nExercise 9")

  def lteqgt(values: Array[Int], v: Int) = {
    (values.count(_ < v), values.count(_ == v), values.count(_ > v))
  }

  val v = 0
  val output = lteqgt(Array(2,-3,-2,9,1,2,3), v)
  println(s"Values less than $v: ${output._1}\nValues equal to $v: ${output._2}\nValues greater than $v: ${output._3}")


  //  10
  println("\n\nExercise 10")
  println("Hello".zip("World"))
  // hmm... salting passwords? something else crypto-related?

}