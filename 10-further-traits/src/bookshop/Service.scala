import DaysOfWeek._

case class Service( title: String,
                    price: Price,
                    provider: String,
                    maintenance: Value = Sunday) extends Sales {

}
