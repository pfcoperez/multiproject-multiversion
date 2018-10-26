package org.pfcoperez

case object VersionFromB {
  def getScalaVersion(): String = scala.util.Properties.versionString
}


