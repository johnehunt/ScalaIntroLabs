package cart

import bookshop.{Address, Author, Book, Price, Publisher, Technical}
import org.scalatest._

class ShoppingCartTest extends FunSpec {

  describe("A Shopping Cart") {
    describe("when empty") {
      it("should return true for isEmpty") {
        val cart = new ShoppingCart()
        assert(cart.isEmpty())
      }
    }
    describe("when one product added") {
      it("should return size = 1") {
        val cart = new ShoppingCart()
        cart.add(getBook)
        assert(cart.size == 1)
      }
      it("should be possible to calculate the total cost") {
        val cart = new ShoppingCart()
        cart.add(getBook)
        val total = cart.total
        assert(total == 15.95)
      }
    }
  }

  private def getBook(): Book = {
    val cart = new ShoppingCart()
    val author = Author("Pete Smith")
    val address = Address(10, "High Street", "Salisbury", "Wiltshire", "SL10 34D")
    val publisher = Publisher("Tech Books Publishing Ltd.", address)
    val book = new Book("Scala Unleashed", Price(15.95), author, publisher, Technical)
    book
  }

}
