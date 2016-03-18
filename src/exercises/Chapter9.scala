import java.io.{FileInputStream, FileOutputStream, ObjectInputStream, ObjectOutputStream}
import scala.collection.mutable.ArrayBuffer
import scala.util.matching.Regex
import java.io.PrintWriter
import scala.io.Source

object Chapter9 extends App {

  // 1
  {
    val source = Source.fromFile("files/lines.txt", "UTF-8")
    val lines = source.getLines.toArray.reverse
    source.close()
    val out = new PrintWriter("files/lines.txt")
    out.println(lines.mkString("\n"))
    out.close()

    println("\n\nExercise 1")
    for (l <- Source.fromFile("files/lines.txt").getLines) println(l)
  }

  // 2
  {
    val source = Source.fromFile("files/tabs.txt")
    val out = new PrintWriter("files/tabs_out.txt")

    val column = 8
    var count = 0

    println("\n\nExercise 2")
    for (c <- source) c match {
      case '\t' => out.print(" " * (column - count % column)); count = 0; // // reset the count if it's a tab
      case '\n' => out.print(c); count = 0; // reset the count if it's a newline
      case _ => out.print(c); count += 1;
    }

    source.close
    out.close
  }


  // 3
  {
    println("\n\nExercise 3")
    Source.fromFile("LICENSE").mkString.split("\\s+").filter(_.length > 12).distinct.foreach(println(_))
  }


  // 4
  {
    println("\n\nExercise 4")
    val numbers = Source.fromFile("files/numbers.txt").mkString.split("\\s+").map(_.toDouble)
    println(s"Numbers: ${numbers.mkString(", ")}")
    println(s"Sum: ${numbers.sum}")
    println(f"Average: ${numbers.sum / numbers.length}")
    println(s"Max: ${numbers.max}")
    println(s"Min: ${numbers.min}")
  }


  // 5
  {
    val spacing = 8
    val maxPowers = 5

    println("\n\nExercise 5")
    for (i <- 1 to maxPowers; n = math.pow(2.0, i); n2 = math.pow(2.0, -i)) {
      val length = n.toString.length
      val space = " " * (spacing - length % spacing)
      println(s"2^$i, 2^-$i:   " + n + space + n2)
    }
  }


  // 6
  {
    // need regex for quoted strings, with escapable chars inside of them
    println("\n\nExercise 6")
    val pattern = """"(.*?)[^\\]"""".r
    for (str <- Source.fromFile("files/complex.txt").getLines) {
      pattern.findFirstIn(str) match {
        case Some(s: String) => println(s)
        case None =>
      }
    }
  }


  // 7
  {
    println("\n\nExercise 7")
    val pattern = """[\d\.\d+]+""".r
    for (token <- Source.fromFile("files/numbers_words.txt").mkString.split("\\s+")) {
      pattern.findFirstIn(token) match {
        case Some(s: String) => println(s)
        case None => false
      }
    }
  }


  // 8
  {
    val uri = "http://www.landmarkworldwide.com/"
    val imgPattern = "<img.+?src=[\"'](.+?)[\"'].*?>".r
    val source = Source.fromURL(uri).mkString
    val matches = imgPattern.findAllIn(source).toArray

    println("\n\nExercise 8")
    var count = 0
    for (imgPattern(src) <- imgPattern.findAllIn(source)) {
      println(src)
      count += 1
    }

    println(s"Count of images: $count")
  }


  // 9
  {
    import java.io.File

    def countMatchingFiles(dir: File, pattern: Regex): Int = {
      val subdirs = dir.listFiles.filter(_.isDirectory)
      val fileNames = dir.listFiles.filter(_.isFile).map(_.getName)

      // add number of files matching in this dir + the recursive count from subdirs
      (for (f <- fileNames; s <- pattern.findFirstIn(f)) yield s).size + subdirs.map(countMatchingFiles(_, pattern)).sum
    }

    println("\n\nExercise 9")
    val baseDir = new File(".")

    val count = countMatchingFiles(baseDir, """.class""".r)
    println(s"Count: $count")
  }


  // 10
  {
    class Person(val name: String) extends Serializable {
      val friends = new ArrayBuffer[Person]

      def friend(f: Person) = friends += f

      override def toString = s"$name has friends: ${friends.map(_.name).mkString(", ")}"
    }

    object Person {
      def apply(name: String) = new Person(name)
    }

    val matt = Person("matt")
    val paul = Person("paul")
    val darieus = Person("darieus")
    val cam = Person("cam")


    matt friend paul
    matt friend cam
    paul friend matt
    cam friend matt
    cam friend darieus
    darieus friend cam

    val all = Array(matt, paul, cam, darieus)

    println("\n\nExercise 10")
    println(s"Original objects:\n${all.mkString("\n")}")

    // save to file
    val filename = "files/friends.dat"
    val out = new ObjectOutputStream(new FileOutputStream(filename))
    out.writeObject(all)
    out.close

    // read back in
    val in = new ObjectInputStream(new FileInputStream(filename))
    val reloaded = in.readObject().asInstanceOf[Array[Person]]
    in.close

    println(s"\n\n\nReloaded objects:\n${reloaded.mkString("\n")}")
  }

}
