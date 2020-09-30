package main

import bookshop.{Book, Bookshop, Technical}

object BookshopApp extends App {

  val prettyPrint = (book: Book) => println(s"${book.title}\n\tby ${book.author},\n\t\tat a cost of ${book.price}")

  println("Welcome to the Bookshop\n")

  Bookshop.printDetails()

  val books = Bookshop.books(Technical)
  prettyPrint(books.head)

  println("Done")

}
