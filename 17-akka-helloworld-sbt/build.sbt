scalaVersion := "2.13.7"

name := "17-akka-helloworld-sbt"
organization := "com.jjh"
version := "1.0.0"

lazy val akkaVersion = "2.6.16"

libraryDependencies += "com.typesafe.akka" %% "akka-actor-typed" % akkaVersion
libraryDependencies += "com.typesafe.akka" %% "akka-actor-testkit-typed" % akkaVersion % Test

libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.4"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.6"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.10" % Test
libraryDependencies += "org.scalamock" %% "scalamock" % "5.1.0" % Test