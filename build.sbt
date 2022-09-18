name := "scalafx.stats"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "2.13.8"
libraryDependencies ++= {
  Seq(
    "org.scalafx" %% "scalafx" % "18.0.2-R29",
    "org.scalatest" %% "scalatest" % "3.2.13" % Test
  )
}
