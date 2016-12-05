import com.typesafe.sbt.SbtNativePackager.autoImport._
import com.typesafe.sbt.web.SbtWeb
import com.typesafe.sbt.web.SbtWeb.autoImport._
import com.typesafe.sbt.gzip.Import.gzip
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt.Keys._
import sbt._

lazy val bintrayPublishIvyStyle = settingKey[Boolean]("=== !publishMavenStyle") //workaround for sbt-bintray bug

lazy val publishSettings = Seq(
  bintrayRepository := "denigma-releases",
  bintrayOrganization := Some("denigma"),
  licenses += ("MPL-2.0", url("http://opensource.org/licenses/MPL-2.0")),
  bintrayPublishIvyStyle := true,
  scalaVersion := Versions.scala
)


//settings for all the projects
lazy val commonSettings = Seq(
  scalaVersion := Versions.scala,
  organization := "org.denigma",
  scalacOptions ++= Seq( "-feature", "-language:_" ),
  javacOptions ++= Seq("-encoding", "UTF-8"),
  parallelExecution in Test := false,
  resolvers += sbt.Resolver.bintrayRepo("denigma", "denigma-releases"),
  resolvers += Resolver.jcenterRepo,
  unmanagedClasspath in Compile ++= (unmanagedResources in Compile).value,
  updateOptions := updateOptions.value.withCachedResolution(true) //to speed up dependency resolution
  //addCompilerPlugin("org.scalamacros" % "paradise" % Versions.macroParadise cross CrossVersion.full)
)

lazy val expressions = crossProject
  .crossType(CrossType.Full)
  .in(file("expressions"))
  .settings(commonSettings ++ publishSettings: _*)
  .settings(
    name := "expressions",
    version := Versions.expressions
  ).disablePlugins(RevolverPlugin)
  .jsConfigure(p => p.enablePlugins(ScalaJSWeb))
  .jsSettings(
    persistLauncher in Compile := true,
    persistLauncher in Test := false
  )
  .jvmSettings(
    (emitSourceMaps in fullOptJS) := true
  )

lazy val expressionsJVM = expressions.jvm
lazy val expressionsJS = expressions.js

lazy val root = Project("root",file("."),settings = commonSettings)
  .settings(
    name := "root",
    version := Versions.expressions,
    mainClass in Compile := Some("org.denigma.genetics.Main"),
    maintainer := "Anton Kulaga <antonkulaga@gmail.com>",
    packageSummary := "kappa-notebook",
    packageDescription := """Genetics applications does diff expressions analysis""",
    javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint", "-J-Xss5M"),
    scalacOptions += "-target:jvm-1.8"
  ) dependsOn expressionsJVM aggregate(expressionsJVM, expressionsJS)
