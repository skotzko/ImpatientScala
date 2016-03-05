package exercises

import javax.print.attribute.standard.PrinterMoreInfoManufacturer

import scala.util.Random

object Chapter5 extends App {

  //  1
  class Counter {
    private var value = Int.MaxValue - 1
    def increment() {if (value + 1 > value) value += 1}
    def current = value
    override def toString() = "Counter:" + value
  }

  println("\n\nExercise 1")
  val c = new Counter
  println(c)

  c.increment()
  println(c)

  c.increment()
  println(c)

  c.increment()
  println(c)

  // 2
  class BankAccount {
    private var _balance = 0.0

    def withdraw(amount: Double) {
      if (amount > 0) _balance -= amount
    }

    def deposit(amount: Double) {
      if (amount > 0) _balance += amount
    }

    def current = _balance

    override def toString = "Balance: " + current
  }

  println("\n\nExercise 2")

  val ba = new BankAccount
  println(ba)

  ba.withdraw(500)
  println(ba)

  ba.deposit(1000)
  println(ba)


  // 3
  {
    class Time(val hrs: Int, val min: Int) {
      def before(other: Time) = hrs < other.hrs || hrs == other.hrs && min < other.min

      override def toString = s"$hrs:$min"
    }

    println("\n\nExercise 3")

    val t = new Time(17, 36)
    val t2 = new Time(17, 50)

    print("Time#before working? ")
    println(t.before(t2))
  }


  // 4
  {
    class Time(val hrs: Int, val min: Int) {
      private val minutesSinceMidnight = (hrs * 60) + min

      def before(other: Time) = minutesSinceMidnight < other.minutesSinceMidnight

      override def toString = s"$hrs:$min"
    }

    println("\n\nExercise 4")
    val t = new Time(17, 36)
    val t2 = new Time(17, 50)
    println(t, t2)
    print("Time#before working? ")
    println(t.before(t2))
  }


  // 5
  {
    import beans.BeanProperty

    class Student(@BeanProperty var name: String, @BeanProperty var id: Long) {
      override def toString = s"Name: $name | Id: $id"
    }

    // generates:
    // name
    // name_=
    // getName()
    // setName()
    // id
    // id_=
    // getId()
    // setId()

    println("\n\nExercise 5")

    val s = new Student("andrew", Random.nextLong)
    println(s)

    println(s.getName, s.getId)

    s.setId(Random.nextLong)
    println(s)

    s.setName("jon")
    println(s)

    // Can use the JavaBeans methods in Scala? Yes. Should you? I say no,
    // leave those for java tools. (I don't really know, just a hunch.)
  }


  // 6
  {
    // don't see a class Person per exercise, making own version
    class Person(var name: String, ageInput: Int) {
      var age = if (ageInput < 0) 0 else ageInput

      override def toString = s"$name is $age"
    }

    println("\n\nExercise 6")
    val p = new Person("Andrew", 29)
    val p2 = new Person("Cam", -35)

    println(p)
    println(p2)
  }


  // 7
  {
    class Person(fullName: String) {
      val Array(firstName, lastName) = fullName.split(' ')

      override def toString = s"First name: $firstName | Last name: $lastName"
    }


    println("\n\nExercise 7")
    val p = new Person("andrew skotzko")
    println(p)

    // primary constructor param should be a plain param so it doesn't generate fields.
    // it's just input to be transformed/validated by primary constructor
  }


  // 8
  {
    class Car(val make: String, val model: String, val year: Int = -1, var plate: String = "") {
      override def toString = s"Make: $make\nModel: $model\nYear: $year\nPlate: $plate"
    }


    println("\n\nExercise 8")
    val c = new Car("Honda", "Civic", 2009)
    println(c)
    // can do this all with 1 constructor so the question doesn't make sense
  }


  // 9
  // see Chapter5_java
  // Damn. Scala version is 3 lines. Java version is 43. :-/


  // 10
  {
    // original version, just for reference
    class Employee(val name: String, var salary: Double) {
      def this() {
        this("John Q. Public", 0.0)
      }
    }
  }

  // primary ctor + explicit fields version
  {
    class Employee(inputName: String = "John Q. Public", inputSalary: Double = 0.0) {
      val name: String = inputName
      val salary: Double = inputSalary

      override def toString = s"$name is paid $salary"
    }

    println("\n\nExercise 10")
    val e = new Employee("John Legend")
    val e2 = new Employee(inputSalary = 150.75)

    println(e)
    println(e2)

    // I prefer this approach to the 2-ctor approach.
  }


}

//9. Reimplement the class of the preceding exercise in Java, C#, or C++ (your choice). How much shorter is the Scala class?


//10. Consider the class
//class Employee(val name: String, var salary: Double) { def this() { this("John Q. Public", 0.0) }}
//Rewrite it to use explicit fields and a default primary constructor. Which form do you prefer? Why?