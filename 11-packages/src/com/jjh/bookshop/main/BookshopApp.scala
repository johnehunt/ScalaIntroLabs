package com.jjh.bookshop.main

object BookshopApp extends App {
  println("Welcome to the Bookshop\n")

  Bookshop.printDetails()

  Bookshop.book.price.print()

  println("Done")
}
