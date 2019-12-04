package bookshop

object BookshopRepository {
  def getBooks(): Book = {
    val author = new Author("Pete Smith")
    val address = new Address(10, "High Street", "Salisbury", "Wiltshire", "SL10 34D")
    val publisher = new Publisher("Tech Books Publishing Ltd.", address)
    val book = new Book("Scala Unleashed", 15.95, author, publisher)
    return book
  }
}

object Bookshop {
  val name = "Scala Books of the World"
  val address = new Address(26, "Main Street", "Bath", "BANES", "BA1 3ZZ")
  val books = BookshopRepository.getBooks()

  def printDetails(): Unit = {
    println(s"name: $name")
    println(s"address: $address")
    println(s"Books: $books")
  }

}
