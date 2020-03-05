package specs

import bookshop.{Address, Author, Book, Price, Publisher, Technical}
import cart.ShoppingCart
import org.specs2.mutable._

class ShoppingCartSpecs2Test extends Specification {

  "A Shopping Cart" should {
    "return true for isEmpty" in {
      val cart = new ShoppingCart()
      cart.size() must beEqualTo(0)
    }
    "return size 1 when one product is added" in {
      val cart = new ShoppingCart()
      cart.add(getBook())
      cart.size() must beEqualTo(1)
    }
    "be possible to calculate the total cost of the cart" in {
      val cart = new ShoppingCart()
      cart.add(getBook())
      val total = cart.total()
      total must beEqualTo(15.95)
    }
  }

  private def getBook(): Book = {
    val author = Author("Pete Smith")
    val address = Address(10, "High Street", "Salisbury", "Wiltshire", "SL10 34D")
    val publisher = Publisher("Tech Books Publishing Ltd.", address)
    val book = new Book("Scala Unleashed", Price(15.95), author, publisher, Technical)
    book
  }
}
