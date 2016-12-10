import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt._

case class CrossDep(
										 shared: Def.Initialize[Seq[ModuleID]],
										 jvm: Def.Initialize[Seq[ModuleID]] = Def.setting(Seq.empty[ModuleID]),
										 js: Def.Initialize[Seq[ModuleID]] = Def.setting(Seq.empty[ModuleID]))

object Dependencies {

  lazy val testing: Def.Initialize[Seq[ModuleID]] = Def.setting(Seq(
		"org.scalatest" %%% "scalatest" % "3.0.1" % Test
  ))

	lazy val expressions = CrossDep(
		shared = Def.setting(
			Seq(
			"com.github.marklister" %%% "product-collections" % "1.4.5",
			"com.lihaoyi" %%% "pprint" % "0.4.4"
			)
		),
		jvm = Def.setting(
			Seq(
				"com.iheart" %% "ficus" % "1.4.0"
			)
		)
	)

}

