import sbt._

organization := "io.kyriakos.library"

name := "kyriakos-lib-repository-h2"

version := "0.5.0-SNAPSHOT"

scalaVersion := "2.11.7"

lazy val kyriakosLibRepoH2 = project.in(file("."))

libraryDependencies ++= Seq(
  // scala
  "org.scala-lang" % "scala-library" % "2.11.7",
  // logging
  "ch.qos.logback" % "logback-classic" % "1.1.3",
  "com.typesafe.scala-logging" % "scala-logging_2.11" % "3.1.0",
  // kyriakos
  "io.kyriakos.library" % "kyriakos-lib-crud_2.11" % "0.1.0-SNAPSHOT",
  // database
  "com.hazelcast" % "hazelcast" % "3.5"
)

ivyScala := ivyScala.value map {
  _.copy(overrideScalaVersion = true)
}

scalacOptions ++= Seq("-deprecation", "-feature")

