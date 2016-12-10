import java.io.File

import org.denigma.genetics.expressions._

import scala.io.Source
import scala.collection._

val files = "/home/antonkulaga/denigma/genetics"
val test = s"${files}/files/test"
val testDiff = s"${test}/gene_exp.diff"
val testUniprot = s"${test}/${FlyConverters.uniprot}"
//val result = CuffDiff.load(testFile)

println("LENGTH = " + new File(testUniprot).length())
val result = Source.fromFile(new File(testUniprot)).getLines().take(100)
result.foreach(r=> println(r))