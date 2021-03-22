package bookshop

object Bookshop {
  val name: String = "Scala Books of the World"
  val address: Address = Address(26, "Main Street", "Bath", "BANES", "BA1 3ZZ")
  val book: Book = setupBook()

  def printDetails(): Unit = {
    println(s"name: $name")
    println(s"address: $address")
    println(s"Book: $book")
  }

  private def setupBook(): Book = {
    val author = Author("Pete Smith")
    val address = Address(10, "High Street", "Salisbury", "Wiltshire", "SL10 34D")
    val publisher = Publisher("Tech Books Publishing Ltd.", address)
    val book = new Book("Scala Unleashed", Price(15.95), Some(author), publisher, Technical)
    book
  }

}
