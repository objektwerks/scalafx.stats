name := "scalafx.stats"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "2.13.10"
libraryDependencies ++= {
  Seq(
    "org.scalafx" %% "scalafx" % "19.0.0-R30",
    "org.scalatest" %% "scalatest" % "3.2.15" % Test
  )
}
