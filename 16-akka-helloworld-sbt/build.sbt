scalaVersion := "2.13.3"

name := "XX5-akka-helloworld-sbt"
organization := "com.jjh"
version := "1.0.0"

lazy val akkaVersion = "2.6.3"

libraryDependencies += "com.typesafe.akka" %% "akka-actor-typed" % akkaVersion
libraryDependencies += "com.typesafe.akka" %% "akka-actor-testkit-typed" % akkaVersion % Test
libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.0" % Test