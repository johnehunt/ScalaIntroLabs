package com.jjh.classic

import akka.actor.ActorSystem
import akka.testkit.{ImplicitSender, TestKit}
import org.scalatest.BeforeAndAfterAll
import org.scalatest.funspec.AnyFunSpecLike

class FactorialProcessorActorTest
  extends TestKit(ActorSystem("MyTestActorSystem"))
  with ImplicitSender
  with AnyFunSpecLike
  with BeforeAndAfterAll {

  describe("A FactorialProcessorActor") {
    describe("when sent a message") {
      it("should calculate the factorial of that number") {
        val actor = system.actorOf(FactorialProcessorActor.props)
        actor ! 4
        expectMsg(24)
      }
    }
  }

  override def afterAll: Unit = {
    TestKit.shutdownActorSystem(system)
  }

}
