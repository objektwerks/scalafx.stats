name := "scalafx.stats"
organization := "objektwerks"
version := "0.4-SNAPSHOT"
scalaVersion := "3.7.2-RC1"
libraryDependencies ++= {
  Seq(
    "org.scalafx" %% "scalafx" % "24.0.0-R35",
    "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5",
    "ch.qos.logback" % "logback-classic" % "1.5.18",
    "org.scalatest" %% "scalatest" % "3.2.19" % Test
  )
}
scalacOptions ++= Seq(
  "-Wunused:all",
  // Silences 3.7.0+ implicit using warnings:
  "-Wconf:msg=Implicit parameters should be provided with a `using` clause:s"
)
