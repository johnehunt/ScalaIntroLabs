package main

import bookshop.{Book, Bookshop, Technical}

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
}
