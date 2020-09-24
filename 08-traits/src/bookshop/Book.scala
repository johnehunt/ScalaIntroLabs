package bookshop

trait Sales {
  val price: Price // Abstract property price
  private var salePercentage = 0.0

  def setSaleDiscount(salePercentage: Double): Unit = {
    this.salePercentage = salePercentage / 100
  }

  def calculateSalePrice(): Price = {
    price - (price * salePercentage)
  }
}

abstract class Product(val title: String, val price: Price) extends Sales {
  override def toString: String = s"$title, $price"
}

class Book(_title: String, _price: Price, val author: Author, val publisher: Publisher, val genre: Genre) extends Product(_title, _price) {
  override def toString: String = s"Book(${super.toString}, $author, Genre: $genre, \n$publisher)"
}

abstract class Entity(val name: String)

case class Author(_name: String) extends Entity(_name)

case class Publisher(_name: String, address: Address) extends Entity(_name)

case class Address(number: Int, street: String, city: String, county: String, postcode: String)

case class Price(value: Double) extends AnyVal {
  def +(p: Price): Price = Price(value + p.value)

  def -(p: Price): Price = Price(value - p.value)

  def *(d: Double): Price = Price(value * d)

  def /(d: Double): Price = Price(value / d)

  def print(): Unit = println(s"Price($value)")
}

