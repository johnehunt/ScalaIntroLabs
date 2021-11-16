package bookshop

// Classes for the book

class Book(val title: String,
           var price: Double,
           val author: Option[Author],
           val publisher: Publisher) {

  private var salePercentage: Double = 0.0

  def setSaleDiscount(salePercentage: Double): Unit =
    this.salePercentage = salePercentage / 100

  def calculateSalePrice(): Double = price - (price * salePercentage)

  override def toString(): String = s"Book($title, $price, ${author.getOrElse("Anonymous")}, \n$publisher)"
}

class Author(val name: String) {
  override def toString: String = name
}

class Publisher(val name: String,
                var address: Address) {
  override def toString(): String = s"$name,\n$address"
}

class Address(val number: Int,
              val street: String,
              val city: String,
              val county: String,
              val postcode: String) {
  override def toString: String = s"$number $street,\n$city,\n$county,\n$postcode"
}
