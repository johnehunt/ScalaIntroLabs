/**
 * Extends the Bookshop application such that it creates
 * a Book and associated instances such as Author, Address etc.
 */
object BookshopApp extends App {
  println("Welcome to the Bookshop\n")

  val author = new Author("Pete Smith")
  val address = new Address(10, "High Street", "Salisbury", "Wiltshire", "SL10 34D")
  val publisher = new Publisher("Tech Books Publishing Ltd.", address)
  val book = new Book("Scala Unleashed", 15.95, author, publisher)
  println(s"Book: $book")

  println("\nCalculating the Sales Discount price")
  book.setSaleDiscount(10.0)

  println(s"Sale price of book: ${book.calculateSalePrice()}")

  println(f"Sale price of book: ${book.calculateSalePrice()}%.2f")
}
