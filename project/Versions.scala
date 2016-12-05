object Versions extends WebJarsVersions with ScalaJSVersions with ScalaJVMVersions with SharedVersions
{
	val sourcecode = "0.1.1"

	val bananaRdf = "0.8.3-SNAP1"

	val expressions = "0.0.1"

	val scala = "2.12.0"

	//val scala = "2.11.5"

}

trait ScalaJVMVersions {

	val akka = "2.4.14"

	val akkaHttp = "10.0.0"

	val akkaHttpExtensions = "0.0.15"

	val ammonite = "0.5.7"

	val seleniumJava = "3.0.1"

	val config = "1.3.0"

	val ficus = "1.3.4"

	val betterFiles = "2.16.0"

	val scalaJSscripts = "1.1.0"
}

trait ScalaJSVersions {

 	val dom = "0.9.1"

	val jqueryFacade = "1.0-RC6"

}

// versions for libs that are shared between client and server
trait SharedVersions
{
	val scalaRx = "0.3.2"

	val scalaTags = "0.6.2"

	val scalaCSS = "0.5.1"

	val macroParadise = "3.0.0.137"

	val scalaTest = "3.0.1"

	val booPickle = "1.2.4"

	val productCollections = "1.4.5"

	val fastparse = "0.4.2"

	val pprint = "0.4.4"

	val scalameta = "1.3.0"
}

trait WebJarsVersions{

	val semanticUI = "2.2.2"

	val codemirror = "5.13.2"

	val threeJS = "r77"

	val webcomponents = "0.7.22"

	val jquery = "3.1.1"
}
