package bookshop

// Classes for the book

class Book(val title: String,
           var price: Double,
           val author: Option[Author],
           val publisher: Publisher) {

  def this(title: String, price: Double, author: Author, publisher: Publisher) =
    this(title, price, Some(author), publisher)

  private var salePercentage: Double = 0.0

  def setSaleDiscount(salePercentage: Double): Unit =
    this.salePercentage = salePercentage / 100

  def calculateSalePrice(): Double = price - (price * salePercentage)

  override def toString(): String = s"Book($title, $price, ${author.getOrElse("Anonymous")}, \n$publisher)"

  override def equals(other: Any): Boolean = other match {
    case that: Book =>
      title == that.title &&
        author == that.author &&
        publisher == that.publisher
    case _ => false
  }

  override def hashCode(): Int = {
    title.hashCode() + author.hashCode() + publisher.hashCode()
  }
}

class Author(val name: String) {
  override def toString: String = name

  def canEqual(other: Any): Boolean = other.isInstanceOf[Author]

  override def equals(other: Any): Boolean = other match {
    case that: Author =>
      (that canEqual this) &&
        name == that.name
    case _ => false
  }

  override def hashCode(): Int = {
    name.hashCode()
  }
}

class Publisher(val name: String,
                var address: Address) {
  override def toString(): String = s"$name,\n$address"

  def canEqual(other: Any): Boolean = other.isInstanceOf[Publisher]

  override def equals(other: Any): Boolean = other match {
    case that: Publisher =>
      (that canEqual this) &&
        name == that.name &&
        address == that.address
    case _ => false
  }

  override def hashCode(): Int = {
    name.hashCode() + address.hashCode()
  }
}

class Address(val number: Int,
              val street: String,
              val city: String,
              val county: String,
              val postcode: String) {
  override def toString: String = s"$number $street,\n$city,\n$county,\n$postcode"

  def canEqual(other: Any): Boolean = other.isInstanceOf[Address]

  override def equals(other: Any): Boolean = other match {
    case that: Address =>
      (that canEqual this) &&
        number == that.number &&
        street == that.street &&
        city == that.city &&
        county == that.county &&
        postcode == that.postcode
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(number, street, city, county, postcode)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}
