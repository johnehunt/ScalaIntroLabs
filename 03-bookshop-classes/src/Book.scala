// Classes for the book

class Book(val title: String,
           var price: Double,
           val author: Author,
           val publisher: Publisher) {

  private var salePercentage: Double = 0.0

  def setSaleDiscount(discount: Double): Unit = {
    salePercentage = discount / 100
  }

  def calculateSalePrice(): Double = price - (price * salePercentage)

  override def toString(): String = s"Book($title, $price, $author, \n$publisher)"
}

class Author(val name: String) {
  override def toString = s"Author($name)"
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
