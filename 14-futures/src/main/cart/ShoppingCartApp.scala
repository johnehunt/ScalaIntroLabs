package cart

import bookshop.{Address, Author, Book, Price, Publisher, Technical}
import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.util.{Success, Failure}


object ShoppingCartApp extends App {


  val cart = new ShoppingCart()
  cart.add(getBook)

  val future = Future {
    cart.total()
  }

  future onComplete {
    case Success(total) => println(s"Success : $total")
    case Failure(e) => println(s"An error occurred $e")
  }

  println("Press Enter to terminate")
  scala.io.StdIn.readLine()

  private def getBook(): Book = {
    val cart = new ShoppingCart()
    val author = Author("Pete Smith")
    val address = Address(10, "High Street", "Salisbury", "Wiltshire", "SL10 34D")
    val publisher = Publisher("Tech Books Publishing Ltd.", address)
    val book = new Book("Scala Unleashed", Price(15.95), author, publisher, Technical)
    book
  }

}
