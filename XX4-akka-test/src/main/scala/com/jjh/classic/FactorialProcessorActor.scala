package com.jjh.classic

import akka.actor._

import scala.annotation.tailrec

object FactorialProcessorActor {
  def props: Props = Props(new FactorialProcessorActor())
}

class FactorialProcessorActor extends Actor {
  def receive: Receive = {
    case x: Int =>
      val result = factorial(n = x)
      sender ! result
  }

  @tailrec
  final def factorial(acc: Int = 1, n: Int): Int =
    if (n == 1)
      acc
    else
      factorial(acc * n, n - 1)
}