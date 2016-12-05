import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt._

case class CrossDep(
										 shared: Def.Initialize[Seq[ModuleID]],
										 jvm: Def.Initialize[Seq[ModuleID]] = Def.setting(Seq.empty[ModuleID]),
										 js: Def.Initialize[Seq[ModuleID]] = Def.setting(Seq.empty[ModuleID]))

object Dependencies {

  lazy val testing: Def.Initialize[Seq[ModuleID]] = Def.setting(Seq(
		"org.scalatest" %%% "scalatest" % Versions.scalaTest % Test
  ))

	val semantic = CrossDep(
		shared = Def.setting(	Seq("org.w3" %%% "banana-plantain" % Versions.bananaRdf) )
	)


	lazy val otherJVM = Def.setting(Seq(
		"org.seleniumhq.selenium" % "selenium-java" % Versions.seleniumJava % Test,

		"com.iheart" %% "ficus" % Versions.ficus,

		"com.github.pathikrit"  %% "better-files-akka"  % Versions.betterFiles,

		"com.vmunier" %% "scalajs-scripts" % Versions.scalaJSscripts
	))



	// akka-related libs
	lazy val akka = Def.setting(Seq(

		"org.denigma" %% "akka-http-extensions" % Versions.akkaHttpExtensions,

		"com.typesafe.akka" %% "akka-stream" % Versions.akka,

		"com.typesafe.akka" %% "akka-http-testkit" % Versions.akkaHttp % Test

	))


	// dependencies on javascript libs
	lazy val webjars= Def.setting(Seq(

		"org.webjars" % "Semantic-UI" %  Versions.semanticUI,

		"org.webjars" % "codemirror" % Versions.codemirror,

		"org.webjars" % "jquery" % Versions.jquery,

		"org.webjars" % "three.js" % Versions.threeJS,

		"org.webjars" % "webcomponentsjs" % Versions.webcomponents
	))

	// common purpose libs
	lazy val styles: Def.Initialize[Seq[ModuleID]] = Def.setting(Seq(
		"com.github.japgolly.scalacss" %%% "core" % Versions.scalaCSS,

		"com.github.japgolly.scalacss" %%% "ext-scalatags" %  Versions.scalaCSS
	))


}

