package exercises

object Chapter6 extends App {

  // 1
  object Conversions {
    def inchesToCentimeters(inches: Double) = 2.54 * inches
    def gallonsToLiters(gallons: Double) = 3.78541 * gallons
    def milesToKilometers(miles: Double) = 1.60934 * miles
  }

  println("\n\nExercise 1")
  println(s"2 inches is ${Conversions.inchesToCentimeters(2)} centimeters")
  println(s"5 gallons is ${Conversions.gallonsToLiters(5)} liters")
  println(s"3 miles is ${Conversions.milesToKilometers(3)} kilometers")


  // 2
  class UnitConversion(val conversionFactor: Double) {
    def convert(amount: Double) = conversionFactor * amount
  }

  object InchesToCentimeters extends UnitConversion(2.54)
  object GallonsToLiters extends UnitConversion(3.78541)
  object MilesToKilometers extends UnitConversion(1.60934)

  println("\n\nExercise 2")
  println(s"2 inches is ${InchesToCentimeters.convert(2)} centimeters")
  println(s"5 gallons is ${GallonsToLiters.convert(5)} liters")
  println(s"3 miles is ${MilesToKilometers.convert(3)} kilometers")


  // 3
  object Origin extends java.awt.Point
  // unclear why this is a bad idea... perhaps because we don't want to allow
  // Origin to move, and Point has setters to allow moving the point?


  // 4
  class Point(val x: Int = 0, val y: Int = 0) {}

  object Point {
    def apply(x: Int, y: Int) = new Point(x, y)
  }


  // 5

  println("\n\nExercise 5")
  object Reverse extends App {
    println(args.reverse.mkString(" "))
  }


  // 6
  object Suits extends Enumeration {
    type Suit = Value // add type alias, to support #7
    val Clubs = Value("♣")
    val Diamonds = Value("♦")
    val Hearts = Value("♥")
    val Spades = Value("♠")
    def isRed(suit: Suit) = suit == Diamonds || suit == Hearts
  }

  println("\n\nExercise 6")
  println(Suits.Clubs)
  println(Suits.Diamonds)
  println(Suits.Hearts)
  println(Suits.Spades)


  // 7
  // check if its red...pattern match?
  println("\n\nExercise 7")
  println(for (s <- Suits.values) yield (s, Suits.isRed(s)))


  // 8
  object RgbColors extends Enumeration {
    type RgbColors = Value
    val black = Value(0x000000, "Black")
    val red = Value(0xff0000, "Red")
    val green = Value(0x00ff00, "Green")
    val blue = Value(0x0000ff, "Blue")
    val yellow = Value(0xffff00, "Yellow")
    val magenta = Value(0xff00ff, "Magenta")
    val cyan = Value(0x00ffff, "Cyan")
    val white = Value(0xffffff, "White")
  }

  println("\n\nExercise 8")
  for(c <- RgbColors.values) println(c.id)

}