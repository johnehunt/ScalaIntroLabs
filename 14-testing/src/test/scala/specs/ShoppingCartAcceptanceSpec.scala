package specs

import bookshop.{Address, Author, Book, Price, Publisher, Technical}
import cart.ShoppingCart
import org.specs2._

class ShoppingCartAcceptanceSpec extends Specification { def is = s2"""

 This is a specification to check the Shopping Cart

 The Shopping Cart string should
   be empty when first created                                   $e1
   hold one item when added                                      $e2
   should calculate the price of the shopping cart               $e3
                                                                 """
  def e1 = {
    val cart = new ShoppingCart()
    cart.size() must beEqualTo(0)
  }
  def e2 = {
    val cart = new ShoppingCart()
    cart.add(getBook())
    cart.size() must beEqualTo(1)
  }
  def e3 = {
    val cart = new ShoppingCart()
    cart.add(getBook())
    val total = cart.total()
    total must beEqualTo(15.95)
  }


  private def getBook(): Book = {
    val author = Author("Pete Smith")
    val address = Address(10, "High Street", "Salisbury", "Wiltshire", "SL10 34D")
    val publisher = Publisher("Tech Books Publishing Ltd.", address)
    val book = new Book("Scala Unleashed", Price(15.95), author, publisher, Technical)
    book
  }
}
