package main

import bookshop.{Book, Bookshop, Technical}

object BookshopApp extends App {

  val prettyPrint = (book: Book) => println(s"${book.title}\n\tby ${book.author},\n\t\tat a cost of ${book.price}")

  println("Welcome to the Bookshop\n")

  //  Bookshop.printDetails()

  val books = Bookshop.books(Technical)

  println("Map example:")
  books.map(b => prettyPrint(b))

  println("Filter example:")
  val filteredList = books.filter(b => b.price.value < 15.0)
  println(filteredList)


}
