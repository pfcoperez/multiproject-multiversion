package org.pfcoperez

import org.pfcoperez.VersionFromB

object Main extends App {
  println(s"From A: B says I am running Scala ${VersionFromB.getScalaVersion()}")
}
