name := "scalafx.stats"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "2.13.5"
libraryDependencies ++= {
  Seq(
    "org.scalafx" %% "scalafx" % "15.0.1-R21",
    "org.scalatest" %% "scalatest" % "3.2.7" % Test
  )
}