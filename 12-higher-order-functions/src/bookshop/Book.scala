package bookshop

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

trait Printable extends Any {
  def print(): Unit = println(this)
}

case class Price(value: Double) extends AnyVal with Printable {
  def +(d: Price): Price = Price(value + d.value)

  def -(d: Price): Price = Price(value - d.value)

  def *(d: Double): Price = Price(value * d)

  def /(d: Double): Price = Price(value / d)
}

