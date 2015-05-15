name := """art-app"""

version := "1.0-SNAPSHOT"

play.PlayImport.PlayKeys.playDefaultPort := 9085

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  javaJpa,
  javaJpa.exclude("org.hibernate.javax.persistence", "hibernate-jpa-2.0-api"),
  "org.hibernate" % "hibernate-entitymanager" % "4.3.8.Final",
  "mysql" % "mysql-connector-java" % "5.1.34",
  "com.google.inject" % "guice" % "4.0-beta",
  "commons-io" % "commons-io" % "2.4",
  cache,
  javaWs
)

