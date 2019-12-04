package bookshop

class Book(val title: String, val price: Price, val author: Author, val publisher: Publisher, val genre: Object) {
  private var salePercentage = 0.0;
  def setSaleDiscount(salePercentage: Double): Unit = {
    this.salePercentage = salePercentage / 100
  }
  def calculateSalePrice(): Price = {
    return price - (price.value * salePercentage)
  }
  override def toString: String = s"Book($title, $price, $author, Genre: $genre, \n$publisher)"
}

case class Author(name: String)

case class Publisher(val name: String, val address: Address)

case class Address(val number: Int, val street: String, val city: String, val county: String, val postcode: String)

case class Price(value: Double) extends AnyVal {
  def +(d: Double): Price = Price(value + d)
  def -(d: Double): Price = Price(value - d)
  def *(d: Double): Price = Price(value * d)
  def /(d: Double): Price = Price(value / d)
}

