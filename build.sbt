name := """art-app"""

version := "1.0-SNAPSHOT"

javaOptions in run += "-Dhttp.port=9085"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  javaJdbc,
  javaJpa,
  javaJpa.exclude("org.hibernate.javax.persistence", "hibernate-jpa-2.0-api"),
  "org.hibernate" % "hibernate-entitymanager" % "4.3.8.Final",
  "mysql" % "mysql-connector-java" % "5.1.34",
  "commons-io" % "commons-io" % "2.4",
  cache,
  javaWs
)

routesGenerator := InjectedRoutesGenerator
