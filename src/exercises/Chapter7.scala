object Chapter7 extends App {

  // 3
//  {
//    package object random {
//      private val a = 1664525
//      private val b = 1013904223
//      private val n = 32
//
//      private var seed = 0
//      def setSeed(seed: Int) = this.seed = seed
//
//      def next() = {
//        val res = (seed * a + b) % (2*n)
//        setSeed(res)
//        res
//      }
//
//      def nextInt() = next()
//
//      def nextDouble() = 1.0 / next()
//    }
//  }

  // 4
  //  I'm guessing the package object was provided to avoid unintentional mistakes, e.g. putting
  // stuff willy nilly wherever, instead of in defined classes/objects.


  // 5
  // This means that giveRaise is visible only in the com package (and narrower inside of it).
  // The value of com depends on where you are so this is only somewhat useful.


  // 6
  {
    import java.util.{HashMap => JavaHashMap}
    import scala.collection.mutable.{HashMap => ScalaHashMap}

    def toScalaMap[K, V](jMap: JavaHashMap[K,V]) = {
      val sMap = new ScalaHashMap[K,V]()
      // need converter
      import collection.convert.wrapAsScala.mapAsScalaMap
      for ((k,v) <- jMap) sMap.put(k,v)
      sMap
    }

    val jMap = new JavaHashMap[String, Int]()
    jMap.put("Andrew", 1)
    jMap.put("Cam", 2)
    jMap.put("Matt", 3)

    println("\n\nExercise 6")
    println(s"Java map: $jMap")
    println(s"Scala map: ${toScalaMap(jMap)}")
  }


  // 7
  // AFAIK, ex. 6 already written w/ imports @ innermost level.


  // 8
  // This imports *everything* in java and javax namespaces and makes those packages available
  // as starting points to access other packages/types.
  // It's subjective, but IMHO this is not a good idea. Crams too much into this context and
  // opens the gates for using the wrong imports, weird breaking changes, etc.


  // 9
  { // no dots!
    import java.lang.System

    println("\n\nExercise 9")

    // get user name
    val user = System getProperty("user.name")

    // get password
    println("enter password:")
    val pw = readLine

    if (pw equals "secret") println(s"Hi there, $user, welcome!")
    else System.err println "Sorry, you have invalid identification. Game over."
  }


  // 10
  // There are a crapton. Go to def below to see, not writing them all.
  scala.StringBuilder

}
