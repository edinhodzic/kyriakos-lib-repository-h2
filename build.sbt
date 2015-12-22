import sbt._

organization := "io.otrl.library"

name := "otrl-lib-repository-h2"

version := "0.5.0-SNAPSHOT"

scalaVersion := "2.11.7"

lazy val otrlLibraryRepositoryH2 = project.in(file("."))

libraryDependencies ++= Seq(
  // scala
  "org.scala-lang" % "scala-library" % "2.11.7",
  // logging
  "ch.qos.logback" % "logback-classic" % "1.1.3",
  "com.typesafe.scala-logging" % "scala-logging_2.11" % "3.1.0",
  // otrl
  "io.otrl.library" % "otrl-lib-repository_2.11" % "0.5.0-SNAPSHOT",
  // database
  "com.hazelcast" % "hazelcast" % "3.5"
)
