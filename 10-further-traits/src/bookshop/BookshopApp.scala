package bookshop

object BookshopApp extends App {
  println("Welcome to the Bookshop\n")

  Bookshop.printDetails()

  Bookshop.book.price.print()

  println("-" * 25)

  val s1 = newService("books", Price(125.55), "Smiths")
  println(s1)
  s1.setSaleDiscount(10.0)
  println(s1.calculateSalePrice())
  println(s"Maintenance day - ${s1.maintenance}")


  println("Done")
}
