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

    // return books
    books
  }
}

object Bookshop {

  import scala.util.{Try, Failure, Success}

  val name: String = "Scala Books of the World"
  val address: Address = Address(26, "Main Street", "Bath", "BANES", "BA1 3ZZ")

  // Functional Exception handling style
  val books: Map[Genre, List[Book]] =
    Try {
      BookshopRepository.getBooks()
    } match {
      case Success(mapOfBooks) => mapOfBooks
      case Failure(e) =>
        println(s"Exception occurred: $e")
        Map[Genre, List[Book]](Technical -> List())
    }

  // Alternative approach - slightly more functional approach
  val books2: Map[Genre, List[Book]] =
    Try {
      BookshopRepository.getBooks()
    } recover {
      case e: BookshopException =>
        println(s"Exception occurred: $e")
        Map[Genre, List[Book]](Technical -> List())
    } match {
      case Success(mapOfBooks) => mapOfBooks
    }

  // Shortest form where not corned about notifying error
  val books3: Map[Genre, List[Book]] =
    Try(BookshopRepository.getBooks())
      .getOrElse(Map[Genre, List[Book]](Technical -> List()))

  println("-" * 30)
  println(s"Loaded books: $books")
  println("-" * 30)

  def printDetails(): Unit = {
    println(s"name: $name")
    println(s"address: $address")
    println(s"Books: $books")
  }

}
