import DaysOfWeek._

class Service private(val title: String,
                      val price: Price,
                      val provider: String,
                      val maintenance: Value) extends Sales {


  override def toString = s"Service($title, $price, $provider, $maintenance)"

  override def equals(other: Any): Boolean = other match {
    case that: Service =>
      title == that.title &&
        price == that.price &&
        provider == that.provider &&
        maintenance == that.maintenance
    case _ => false
  }

  override def hashCode(): Int = {
    title.hashCode() + price.hashCode() + provider.hashCode() + maintenance.hashCode()
  }

  def copy(copyTitle: Option[String] = None,
           copyPrice: Option[Price] = None,
           copyProvider: Option[String] = None,
           copyMaintenance: Option[Value] = None): Service = {
    val newTitle = copyTitle.getOrElse(this.title)
    val newPrice = copyPrice.getOrElse(this.price)
    val newProvider = copyProvider.getOrElse(this.provider)
    val newMaintenance = copyMaintenance.getOrElse(this.maintenance)
    new Service(newTitle, newPrice, newProvider, newMaintenance)
  }

}

object Service {
  def apply(title: String,
            price: Price,
            provider: String,
            maintenance: Value = Sunday): Service =
    new Service(title, price, provider, maintenance)
}

