scalaVersion := "2.13.5"

name := "01-helloworld-sbt"
organization := "com.jjh"
version := "1.0.0"

libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2"
libraryDependencies += "com.typesafe.akka" %% "akka-actor-typed" % "2.6.13"
libraryDependencies += "ch.qos.logback" %% "logback-classic" % "1.2.3"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.6" % Test
libraryDependencies += "org.scalamock" %% "scalamock" % "5.1.0" % Test
libraryDependencies += "com.typesafe.akka" %% "akka-actor-testkit-typed" % "2.6.13" % Test