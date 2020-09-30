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
