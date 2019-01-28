name := """sistemas-web"""
organization := "br.edu.ifrn"

version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.12.7"

libraryDependencies += guice
//libraryDependencies += javaJdbc
//libraryDependencies += "com.h2database" % "h2" % "1.4.192"

libraryDependencies ++= Seq(
javaJdbc,
cache,
javaWs,
"org.xerial" % "sqlite-jdbc" % "3.8.6"
)