package bookshop

object BookshopApp extends App {

  val prettyPrint = (book: Book) => println(s"${book.title}\n\tby ${book.author},\n\t\tat a cost of ${book.price}")

  println("Welcome to the Bookshop\n")

  Bookshop.printDetails()

  val books = Bookshop.books.get(Technical).get
  prettyPrint(books(0))

}
