name := """art-app"""

version := "1.0-SNAPSHOT"

// Only used to be picked up from the jenkins build script to emit the webserver port.
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

// Activate dependency injected controllers and not static controllers.
// This is a new function since play framework 2.4
routesGenerator := InjectedRoutesGenerator

// Required since play framework 2.4 to prevent classpath errors in
// production distribution of the application.
PlayKeys.externalizeResources := false

