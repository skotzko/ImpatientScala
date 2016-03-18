object Chapter8 extends App {

  // 1
  class BankAccount(initialBalance: Double) {
    private var balance = initialBalance

    def currentBalance = balance

    def deposit(amount: Double) = {
      balance += amount;
      println(toString + s" | $amount deposited");
      balance
    }

    def withdraw(amount: Double) = {
      balance -= amount;
      println(toString + s" | $amount withdrawn");
      balance
    }

    // adding this to simplify printing out balances repeatedly
    override def toString = s"Balance: $currentBalance"

  }

  class CheckingAccount(initialBalance: Double, val fee: Double = 1.0) extends BankAccount(initialBalance) {
    override def deposit(amount: Double) = super.deposit(amount - fee)

    override def withdraw(amount: Double) = super.withdraw(amount + fee)
  }

  {
    println("\n\nExercise 1")
    val account = new CheckingAccount(100)
    account.deposit(50)
    account.withdraw(50)
  }


  // 2
  class SavingsAccount(initialBalance: Double, val fee: Double = 1.0, val interestRate: Double = 0.015)
    extends BankAccount(initialBalance) {

    private var freeTransactions = 3

    override def deposit(amount: Double) = {
      val _amount = if (freeTransactions <= 0) amount - fee else amount
      super.deposit(_amount)
      freeTransactions -= 1
      currentBalance
    }

    override def withdraw(amount: Double) = {
      val _amount = if (freeTransactions <= 0) amount + fee else amount
      super.withdraw(_amount)
      freeTransactions -= 1
      currentBalance
    }


    def earnMonthlyInterest = {
      super.deposit(currentBalance * interestRate)
      resetFreeTransactions
    }

    def resetFreeTransactions: Unit = {
      freeTransactions = 3
    }
  }


  {
    println("\n\nExercise 2")
    val account = new SavingsAccount(100)
    account.deposit(50)
    account.deposit(50)
    account.withdraw(20)
    println("transactions should now start showing fees...")
    account.withdraw(25)
    account.deposit(100)
    account.withdraw(75)
  }


  // 3
  // can't think of an example I like so I'm gonna make up one. What am I in the mood for? Wine. Let's go with that.
  // Beverage
  // + Wine
  //  + RedWine
  //  + WhiteWine
  // + Beer

  class Beverage(val name: String, val year: Int, val maxPerDay: Int)

  class Wine(name: String, year: Int, maxPerDay: Int = 2, val producer: String, val origin: String, val color: String)
    extends Beverage(name, year, maxPerDay)

  class RedWine(name: String, year: Int, maxPerDay: Int, producer: String, origin: String)
    extends Wine(name, year, maxPerDay, producer, origin, color = "Red")

  class WhiteWine(name: String, year: Int, maxPerDay: Int, producer: String, origin: String)
    extends Wine(name, year, maxPerDay, producer, origin, color = "White")

  class Beer(name: String, year: Int, maxPerDay: Int, val brewery: String = "Adroit Theory", val `type`: String)
    extends Beverage(name, year, maxPerDay)


  // 4
  abstract class Item {
    def price: Double

    def description: String

    override def toString = s"$description for $$$price"
  }

  class SimpleItem(val price: Double, val description: String) extends Item

  class Bundle(val description: String, otherItems: Item*) extends Item {
    private val items = Array(otherItems: _*)

    def addItem(item: Item) = items :+ item

    def price = items.map(_.price).sum

    override def toString = s"$description: " + items.mkString(", ")
  }

  {
    println("\n\nExercise 4")
    val block = new SimpleItem(2, "a block")
    val chair = new SimpleItem(75, "a chair")
    val pen = new SimpleItem(4.5, "a pen")
    val _items = Array(block, chair, pen)
    val items = new Bundle("a bundle of items", _items: _*)
    println(items)

  }


  // 5
  class Point(val x: Double = 0, val y: Double = 0) {
    override def toString = s"Point ($x, $y)"
  }

  class LabeledPoint(val label: String, x: Double, y: Double) extends Point(x, y) {
    override def toString = s"$label | " + super.toString
  }

  {
    println("\n\nExercise 5")
    val p = new Point(5, 3)
    println(p)
    val p2 = new LabeledPoint("a labeled point", 12, 18)
    println(p2)
  }


  // 6
  abstract class Shape {
    def centerPoint: Point;
  }

  class Rectangle(val width: Double, val height: Double, val basePoint: Point = new Point(0, 0)) extends Shape {
    def centerPoint = new Point(basePoint.x + (width / 2), basePoint.y + (height / 2))
  }

  // (x,y) will be center
  class Circle(x: Double, y: Double, val radius: Double = 2) extends Shape {
    def diameter = radius * 2

    def area = math.Pi * math.pow(radius, 2)

    def centerPoint = new Point(x, y)
  }


  {
    println("\n\nExercise 6")
    val r = new Rectangle(5, 10, new Point(2, 4))
    println(r.centerPoint)
    val r2 = new Rectangle(5, 10, new Point(2, 4))
    println(r2.centerPoint)

    val c = new Circle(3, 5)
    println(c.area, c.centerPoint)
  }


  // 7
  class Square(x: Int, y: Int, width: Int) extends java.awt.Rectangle(x, y, width, width)


  // 8
  // from p. 91
  class Person(val name: String) {
    override def toString = getClass.getName + "[name=" + name + "]"
  }

  class SecretAgent(codename: String) extends Person(codename) {
    override val name = "secret"
    // Don’t want to reveal name . . .
    override val toString = "secret" // . . . or class name
  }

  // output...
  //  $ javap -private Chapter8\$Person
  //  Compiled from "Chapter8.scala"
  //  public class Chapter8$Person {
  //    private final java.lang.String name;
  //    public java.lang.String name();
  //    public java.lang.String toString();
  //    public Chapter8$Person(java.lang.String);
  //  }
  //  1 field, 1 getter, no setters, gets the name


  //  javap -p Chapter8\$SecretAgent
  //  Compiled from "Chapter8.scala"
  //  public class Chapter8$SecretAgent extends Chapter8$Person {
  //    private final java.lang.String name;
  //    private final java.lang.String toString;
  //    public java.lang.String name();
  //    public java.lang.String toString();
  //    public Chapter8$SecretAgent(java.lang.String);
  //  }



  // 9
  { // original text, added toString
  class Creature {
    val range: Int = 10
    val env: Array[Int] = new Array[Int](range)
    override def toString = super.toString + " Range:" + range + " Environment:" + env.toBuffer
  }
    class Ant extends Creature {
      override val range = 2
    }
    println("\n\nExercise 9.0")
    println(new Creature)
    println(new Ant)
    // notice Ant's env was constructed with range=0 as explained in the text, even though 2 is in the println
  }
  {
    class Creature {
      def range: Int = 10
      val env: Array[Int] = new Array[Int](range)
      override def toString = super.toString + " Range:" + range + " Environment:" + env.toBuffer
    }

    class Ant extends Creature {
      override def range = 2
    }
    println("\n\nExercise 9.1")
    println(new Creature)
    println(new Ant)

  }
  {
    class Creature {
      def range: Int = 10
      val env: Array[Int] = new Array[Int](range)
      override def toString = super.toString + " Range:" + range + " Environment:" + env.toBuffer
    }

    class Ant extends Creature {
      override val range = 2
    }
    println("\n\nExercise 9.2")
    println(new Creature)
    println(new Ant)
  }

  // when we use a def in the subclass, we ensure the right value is returned to the superclass
  // during object construction. see p95 around construction order


  // 10
  // not totally sure, but I *think* the 'protected' keyword before the parents protects the primary
  // constructor and limits it to subclasses. The 'protected' keyword for the 'val elems' makes that field
  // only visible to the subclasses. Also recall that 'protected' in scala is not visible to the rest of package
  // like in java.
}