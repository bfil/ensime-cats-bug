import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

import cats.data.XorT
import cats.std.future.futureInstance
import cats.std.list.listInstance
import cats.syntax.cartesian._
import cats.syntax.traverse.traverseSyntax

object Main extends App {

  case class Error(message: String)

  val value: XorT[Future, Error, String] = XorT.right(Future("Ok"))

  List(value, value).sequenceU

  (value |@| value |@| value) map {
    case (a, b, c) => (a, b, c)
  }

}
