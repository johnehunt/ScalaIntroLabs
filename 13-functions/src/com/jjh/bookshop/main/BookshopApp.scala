package com.jjh.bookshop.main

import com.jjh.bookshop.domain._

object BookshopApp extends App {

  val prettyPrint = (book: Book) =>
    println(s"${book.title}\n\tby ${book.author.getOrElse("Anonymous")},\n\t\tat a cost of ${book.price}")

  println("Welcome to the Bookshop\n")

  Bookshop.printDetails()

  val books = Bookshop.books(Technical)
  prettyPrint(books.head)

  println("Done")

}
