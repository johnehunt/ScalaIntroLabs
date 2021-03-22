/**
 * Very simple Hello World style Application.
 */
object BookshopApp extends App {
  println("Welcome to the Bookshop")

  val message = "We have a lot of offers today"
  var day = "Monday"

  println(s"$day $message")

  day = "Tuesday"
  println(s"$day - $message")
}
