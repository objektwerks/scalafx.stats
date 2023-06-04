name := "scalafx.stats"
organization := "objektwerks"
version := "0.4-SNAPSHOT"
scalaVersion := "3.3.1-RC1"
libraryDependencies ++= {
  Seq(
    "org.scalafx" %% "scalafx" % "20.0.0-R31",
    "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5",
    "ch.qos.logback" % "logback-classic" % "1.4.7",
    "org.scalatest" %% "scalatest" % "3.2.15" % Test
  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)
