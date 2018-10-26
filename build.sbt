name := "multiproject-multiversion"

lazy val commonSettings = Seq(
  organization := "org.pfcoperez",
  version := "0.1",
  scalaVersion := "2.12.6"
)

lazy val a = (project in file("a"))
  .dependsOn(b)
  .settings(
    commonSettings
  )
  .settings(
    crossScalaVersions := Seq("2.11.12", "2.12.6")
  )

lazy val b = (project in file("b"))
  .settings(
    commonSettings
  )
  .settings(
    crossScalaVersions := Seq("2.11.12", "2.12.6")
  )

lazy val c = (project in file("c"))
  .dependsOn(b)
  .settings(
    commonSettings
  )
  .settings(
    scalaVersion := "2.11.12",
    crossScalaVersions := Seq("2.11.12")
  )





