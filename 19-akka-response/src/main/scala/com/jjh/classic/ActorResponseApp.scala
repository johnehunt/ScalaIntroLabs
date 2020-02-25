package com.jjh.classic

import akka.actor._

import scala.annotation.tailrec

object FactorialProcessorActor {
  def props: Props = Props(new FactorialProcessorActor())
}

class FactorialProcessorActor extends Actor {
  def receive: Receive = {
    case x: Int =>
      println("Calculator received: " + x)
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

class ControllerActor extends Actor {
  def receive: Receive = {
    case "start" =>
      println("Controller starting calculator")
      context.actorOf(FactorialProcessorActor.props) ! 4
      println("Controller message sent")
    case result: Int =>
      println("Controller received: " + result)
      context.stop(self)
  }
}

object ControllerActor {
  def props: Props = Props(classOf[ControllerActor])
}

object ActorResponseApp extends App {
  val system = ActorSystem("MyActorSystem")
  val controller = system.actorOf(ControllerActor.props)
  controller ! "start"

  //shutdown the actor system
  system.terminate()
}