package com.jjh.bookshop.cart

import bookshop.{Address, Author, Book, Price, Publisher, Technical}
import org.scalatest.funspec.AnyFunSpec

class ShoppingCartTest extends AnyFunSpec {

  private var cart: Option[ShoppingCart] = None

  override def beforeEach(): Unit = {
    cart = Some(new ShoppingCart())
  }

  override def afterEach(): Unit = {
    cart = None
  }

  describe("A Shopping Cart") {
    describe("when empty") {
      it("should return true for isEmpty") {
        assert(cart.get.isEmpty())
      }
    }
    describe("when one product added") {
      it("should return size = 1") {
        cart.get.add(getBook())
        assert(cart.size == 1)
      }
      it("should be possible to calculate the total cost") {
        cart.get.add(getBook())
        val total = cart.get.total()
        assert(total == 15.95)
      }
      it("should be possible to remove that product") {
        val book = getBook()
        cart.get.add(book)
        cart.get.remove(book)
        assert(cart.get.isEmpty())
      }
    }
  }


  /**
   * Private method used to support the tests
   * in this class.
   */
  private def getBook(): Book = {
    val author = Author("Pete Smith")
    val address = Address(10, "High Street", "Salisbury", "Wiltshire", "SL10 34D")
    val publisher = Publisher("Tech Books Publishing Ltd.", address)
    new Book("Scala Unleashed", Price(15.95), author, publisher, Technical)
  }

}
