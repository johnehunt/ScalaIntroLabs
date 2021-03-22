package com.jjh.bookshop.main

import com.jjh.bookshop.domain._
import scala.util.{Failure, Success, Try}

object BookshopApp extends App {

  val prettyPrint = (book: Book) => println(s"${book.title}\n\tby ${book.author},\n\t\tat a cost of ${book.price}")

  println("Welcome to the Bookshop\n")

  //  Bookshop.printDetails()

  val books = Bookshop.books.getOrElse(Technical, Nil)

  println("Foreach example:")
  books.foreach(b => prettyPrint(b))

  println("-" * 25)

  println("Filter example:")
  val filteredList = books.filter(b => b.price.value < 15.0)
  println(filteredList)

  println("-" * 25)

  println("Filter and foreach example")
  books.filter(b => b.price.value < 15.0).foreach(b => prettyPrint(b))

  println("-" * 25)
  // Extension Point
  Bookshop.applyToGenre(Technical, prettyPrint)
  Bookshop.applyToGenre(Technical, (b: Book) => println(b))

  try {
    // test exception handling
    val author = Author("Paul Lawton")
    val address = Address(11, "Market Street", "Swindon", "Wiltshire", "SN10 5LD")
    val publisher = Publisher("Tech Books Publishing Ltd.", address)
    val book = new Book("Future Scala", Price(-5.95), Some(author), publisher, Technical)
    println(book)
  } catch {
    case e: BookshopException =>
      e.printStackTrace()
      println("Caught the exception")
  }

  Try {
    // test exception handling
    val author = Author("Paul Lawton")
    val address = Address(11, "Market Street", "Swindon", "Wiltshire", "SN10 5LD")
    val publisher = Publisher("Tech Books Publishing Ltd.", address)
    val book = new Book("Future Scala", Price(-5.95), Some(author), publisher, Technical)
  } match {
    case Success(book) => println(book)
    case Failure(exp) => exp.printStackTrace()
  }


}
