package bookshop

object Bookshop {
  val name: String = "Scala Books of the World"
  val address: Address = Address(26, "Main Street", "Bath", "BANES", "BA1 3ZZ")
  val books: Book = BookshopRepository.getBooks()

  def printDetails(): Unit = {
    println(s"name: $name")
    println(s"address: $address")
    println(s"Books: $books")
  }

  def getBooks(): Book = {
    val author = Author("Pete Smith")
    val address = Address(10, "High Street", "Salisbury", "Wiltshire", "SL10 34D")
    val publisher = Publisher("Tech Books Publishing Ltd.", address)
    new Book("Scala Unleashed", Price(15.95), author, publisher, Technical)
  }

}
