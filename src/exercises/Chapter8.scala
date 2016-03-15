object Chapter8 extends App {
  // 1



}

//
//Exercises
//1. Extend the following BankAccount class to a CheckingAccount class that charges $1 for every deposit and withdrawal.
//class BankAccount(initialBalance: Double) {
//  private var balance = initialBalance
//  def currentBalance = balance
//  def deposit(amount: Double) = { balance += amount; balance } def withdraw(amount: Double) = { balance -= amount; balance }
//}


//2. Extend the BankAccount class of the preceding exercise into a class SavingsAccount that earns interest every month (when a method earnMonthlyInterest is called) and has three free deposits or withdrawals every month. Reset the transaction count in the earnMonthlyInterest method.


//3. Consult your favorite Java or C++ textbook that is sure to have an example of a toy inheritance hierarchy, perhaps involving employees, pets, graphical shapes, or the like. Implement the example in Scala.


//4. Define an abstract class Item with methods price and description. A SimpleItem is an item whose price and description are specified in the constructor. Take advantage of the fact that a val can override a def. A Bundle is an item that contains other items. Its price is the sum of the prices in the bundle. Also provide a mechanism for adding items to the bundle and a suitable description method.


//5. Design a class Point whose x and y coordinate values can be provided in a constructor. Provide a subclass LabeledPoint whose constructor takes a label value and x and y coordinates, such as
//  new LabeledPoint("Black Thursday", 1929, 230.07)


//6. Define an abstract class Shape with an abstract method centerPoint and subclasses Rectangle and Circle. Provide appropriate constructors for the subclasses and override the centerPoint method in each subclass.


//7. Provide a class Square that extends java.awt.Rectangle and has three con- structors: one that constructs a square with a given corner point and width, one that constructs a square with corner (0, 0) and a given width, and one that constructs a square with corner (0, 0) and width 0.


//8. Compile the Person and SecretAgent classes in Section 8.6, “Overriding Fields,” on page 89 and analyze the class files with javap. How many name fields are there? How many name getter methods are there? What do they get? (Hint: Use the -c and -private options.)


//9. In the Creature class of Section 8.10, “Construction Order and Early Definitions,” on page 92, replace val range with a def. What happens when you also use a def in the Ant subclass? What happens when you use a val in the subclass? Why?


//10. The file scala/collection/immutable/Stack.scala contains the definition class Stack[A] protected (protected val elems: List[A])
//Explain the meanings of the protected keywords. (Hint: Review the discussion of private constructors in Chapter 5.)