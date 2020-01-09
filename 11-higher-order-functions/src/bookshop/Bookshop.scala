package bookshop

object BookshopRepository {
  def getBooks(): Map[Genre, List[Book]] = {
    val author = Author("Pete Smith")
    val address = Address(10, "High Street", "Salisbury", "Wiltshire", "SL10 34D")
    val publisher = Publisher("Tech Books Publishing Ltd.", address)
    val technicalBooks = List(new Book("Scala Unleashed", Price(15.95), author, publisher, Technical),
      new Book("Python in the Wild", Price(12.55), Author("Joe Jones"), publisher, Technical))

    val historicalPublisher = Publisher("Historical Books Are Us", Address(5, "The Estate", "Market Town", "Hampshire", "HA3 4RR"))
    val historyBooks = List(new Book("The Wars of the Roses Retold", Price(12.34), Author("Pete Andrews"), historicalPublisher, History))

    val fictionPublisher = Publisher("Adriana Books", Address(340, "Long Mile Road", "Swindon", "Wiltshire", "SN12 6ER"))
    val fictionBooks = List(new Book("It was a Dark Night", Price(23.55), Author("Gryff Cooke"), fictionPublisher, Fiction))

    val books = Map[Genre, List[Book]](Technical -> technicalBooks,
      History -> historyBooks,
      Fiction -> fictionBooks)

    // Return the books
    books
  }
}

object Bookshop {
  val name: String = "Scala Books of the World"
  val address: Address = Address(26, "Main Street", "Bath", "BANES", "BA1 3ZZ")
  val books: Map[Genre, List[Book]] = BookshopRepository.getBooks()

  def printDetails(): Unit = {
    println(s"name: $name")
    println(s"address: $address")
    println(s"Books: $books")
  }

}
