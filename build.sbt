name := "objektwerks.scala.stats"
version := "0.1"
scalaVersion := "2.11.8"
ivyScala := ivyScala.value map { _.copy(overrideScalaVersion = true) }
libraryDependencies ++= {
  Seq(
    "org.scalafx" % "scalafx_2.11" % "8.0.60-R9",
    "org.scalatest" % "scalatest_2.11" % "2.2.6" % "test"
  )
}
unmanagedJars in Compile += Attributed.blank(file(System.getenv("JAVA_HOME") + "/jre/lib/ext/jfxrt.jar"))
scalacOptions ++= Seq(
  "-language:postfixOps",
  "-language:implicitConversions",
  "-language:reflectiveCalls",
  "-language:higherKinds",
  "-feature",
  "-unchecked",
  "-deprecation",
  "-Xlint",
  "-Xfatal-warnings"
)
javaOptions += "-server -Xss1m -Xmx2g"
fork in test := true
logLevel := Level.Info
run in Compile <<= Defaults.runTask(fullClasspath in Compile, mainClass in (Compile, run), runner in (Compile, run))
