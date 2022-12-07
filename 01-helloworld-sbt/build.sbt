scalaVersion := "2.13.7"

name := "01-helloworld-sbt"
organization := "com.jjh"
version := "1.0.0"

libraryDependencies += "org.scala-lang.modules" %% "scala-parsercombinators" % "2.1.1"

libraryDependencies += "com.typesafe.akka" %% "akka-actor-typed" % "2.7.0"
libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.4.5"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.14" % Test
libraryDependencies += "org.scalamock" %% "scalamock" % "5.2.0" % Test
libraryDependencies += "com.typesafe.akka" %% "akka-testkit" % "2.7.0" % Test