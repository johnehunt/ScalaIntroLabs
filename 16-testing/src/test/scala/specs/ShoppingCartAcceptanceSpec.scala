package specs

import bookshop._
import com.jjh.bookshop.cart.ShoppingCart
import org.specs2._

class ShoppingCartAcceptanceSpec extends Specification {

  def is = s2"""

 This is a specification to check the Shopping Cart

 The Shopping Cart string should
   be empty when first created                                   $r1
   hold one item when added                                      $r2
   should calculate the price of the shopping cart               $r3
                                                                 """
  def r1 = {
    val cart = new ShoppingCart()
    cart.size() must beEqualTo(0)
  }
  def r2 = {
    val cart = new ShoppingCart()
    cart.add(getBook())
    cart.size() must beEqualTo(1)
  }
  def r3 = {
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
