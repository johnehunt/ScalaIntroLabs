package bookshop

trait Sales {
  val price: Price // Abstract property price
  private var salePercentage = 0.0

  def setSaleDiscount(salePercentage: Double): Unit = {
    if (salePercentage <= 0.0) {
      throw new BookshopException(s"Invalid sale discount: $price")
    }
    this.salePercentage = salePercentage / 100
  }

  def calculateSalePrice(): Price = {
    price - (price * salePercentage)
  }
}
