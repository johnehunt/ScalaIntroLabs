package bookshop

/**
 * Bookshop Repository Singleton object - used to hold books for the bookshop.
 */
object BookshopRepository {
  def getBooks(): Book = {
    val author = new Author("Pete Smith")
    val address = new Address(10, "High Street", "Salisbury", "Wiltshire", "SL10 34D")
    val publisher = new Publisher("Tech Books Publishing Ltd.", address)
    val book = new Book("Scala Unleashed", 15.95, author, publisher)
    book
  }
}

/**
 * Singleton object representing the Bookshop.
 */
object Bookshop {
  val name: String = "Scala Books of the World"
  val address: Address = new Address(26, "Main Street", "Bath", "BANES", "BA1 3ZZ")
  val books: Book = BookshopRepository.getBooks()

  def printDetails(): Unit = {
    println(s"name: $name")
    println(s"address: $address")
    println(s"Books: $books")
  }

}
