package bookshop

object BookshopApp extends App {
  println("Welcome to the Bookshop\n")

  Bookshop.printDetails()

  Bookshop.books.price.print()

  println("Done")
}
