import DaysOfWeek._

class Service(val title: String,
              val price: Price,
              val provider: String,
              val maintenance: WeekDay=Sunday) extends Sales {

  override def toString = s"Service($provider) - ${super.toString()}"

  override def equals(other: Any): Boolean = other match {
    case that: Service =>
        title == that.title &&
        price == that.price &&
          provider == that.provider
    case _ => false
  }

  override def hashCode(): Int = {
    title.hashCode() + price.hashCode() + provider.hashCode()
  }

}
