scalaVersion := "2.13.1"

name := "hello-world"
organization := "com.jjh"
version := "1.0.0"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.1.0" 
libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.0" % "test"
libraryDependencies += "org.scalamock" %% "scalamock" % "4.4.0" % Test
