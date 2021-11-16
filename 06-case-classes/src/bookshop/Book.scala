package bookshop

class Book(val title: String,
           val price: Price,
           val author: Option[Author],
           val publisher: Publisher,
           val genre: Any) {

  private var salePercentage = 0.0

  def setSaleDiscount(salePercentage: Double): Unit = {
    this.salePercentage = salePercentage / 100
  }

  def calculateSalePrice(): Price = price - (price * salePercentage)

  override def toString(): String = s"Book($title, $price, ${author.getOrElse("Anonymous")}, Genre: $genre, \n$publisher)"
}

case class Author(name: String)

case class Publisher(name: String, address: Address)

case class Address(number: Int,
                   street: String,
                   city: String,
                   county: String,
                   postcode: String)

case class Price(value: Double) {
  def +(p: Price): Price = Price(value + p.value)
  def -(p: Price): Price = Price(value - p.value)

  def +(p: Double): Price = Price(value + p)
  def -(p: Double): Price = Price(value - p)

  def *(d: Double): Price = Price(value * d)
  def /(d: Double): Price = Price(value / d)
}

