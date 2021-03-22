package com.jjh

import akka.actor._

/**
 * Simple Actor to illustrate basic idea
 */
class HelloWorldActor extends Actor {
  override def receive: Receive = {
    case "Hello" => println("Hello World")
    case "Goodbye" => println("Goodby World")
    case _ => println ("another Message")
  }
}

/**
 * Driver program for the Actor example
 */
object HelloWorldActorApp extends App {
  val actorSystem = ActorSystem("MyHWActorSystem")
  val actorProps = Props(new HelloWorldActor())
  val actor = actorSystem.actorOf(actorProps)
  actor ! "Hello"
  actor ! "Goodbye"
  actor ! "John"
  actor ! 42

  actorSystem.terminate()
}