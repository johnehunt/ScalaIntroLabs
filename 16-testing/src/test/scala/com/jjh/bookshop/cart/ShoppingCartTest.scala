package com.jjh.bookshop.cart

import com.jjh.bookshop.book.{Address, Author, Book, Publisher, Technical}
import com.jjh.bookshop.util.Price
import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach}
import org.scalatest.funspec.AnyFunSpec

class ShoppingCartTest extends AnyFunSpec
  with BeforeAndAfterEach
  with BeforeAndAfterAll  {

  private var cart: Option[ShoppingCart] = None

  override def beforeAll(): Unit = println("Before All")
  override def afterAll(): Unit = println("After All")

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
        assert(cart.get.size == 1)
      }
      it("should be possible to calculate the total cost of one book") {
        cart.get.add(getBook())
        val total = cart.get.total()
        assert(total == 15.95)
      }
      it("should be possible to calculate the total cost of two books") {
        cart.get.add(getBook())
        cart.get.add(getBook())
        val total = cart.get.total()
        assert(total == 31.9)
      }
      it("should be possible to remove that product") {
        val book = getBook()
        cart.get.add(book)
        assert(cart.get.size == 1)
        cart.get.remove(book)
        assert(cart.get.isEmpty())
      }
    }
  }

  private def getBook(): Book = {
    val author = Author("Pete Smith")
    val address = Address(10, "High Street", "Salisbury", "Wiltshire", "SL10 34D")
    val publisher = Publisher("Tech Books Publishing Ltd.", address)
    new Book("Scala Unleashed", Price(15.95), author, publisher, Technical)
  }
}
