package cart

import scala.collection.mutable.ListBuffer
import bookshop.Product

class ShoppingCart {
  val contents = ListBuffer[Product]()

  def add(product: Product): Unit = {
    contents.addOne(product)
  }

  def remove(product: Product): Unit = {
    val index = contents.indexOf(product)
    if (index != -1) {
      contents.remove(index, 1)
    }
  }

  def isEmpty(): Boolean = {
    contents.isEmpty
  }

  def size(): Int = {
    contents.size
  }

  def total(): Double = {
    Thread.sleep(5000) // simulate time consuming process
    contents.foldLeft(0.0){(total, p) => total + p.price.value}
  }

}
