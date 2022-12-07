package com.jjh.bookshop.main

object BookshopApp extends App {
  println("Welcome to the Bookshop\n")

  Bookshop.printDetails()

  val techBooks = Bookshop.books.getOrElse(Technical, Nil)
  if (techBooks != Nil) {
    val book = techBooks.head
    book.setSaleDiscount(10.0)
    println(book.calculateSalePrice())
  }

  println("Done")
}
