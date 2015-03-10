name := """art-app"""

version := "1.0-SNAPSHOT"

maxmem := "256"

play.PlayImport.PlayKeys.playDefaultPort := 9085

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs
)
