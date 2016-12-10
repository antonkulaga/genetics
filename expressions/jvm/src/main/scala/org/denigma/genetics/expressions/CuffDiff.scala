package org.denigma.genetics.expressions

import java.io.StringReader
import java.io.{File, StringReader}
import java.nio.file._

import scala.collection.JavaConverters._
import com.github.marklister.collections.immutable.CollSeq
import com.github.marklister.collections.io.{CSVReader, CsvParser}

import scala.io.Source

import com.github.marklister.collections.io.CsvParser

object CuffDiff {

  case class DiffExpress(test_id: String,
                         gene_id: String,
                         gene: String,
                         locus: String,
                         sample_1: String,
                         sample_2: String,
                         status: String,
                         value_1: Double,
                         value_2: Double,
                         log2FoldChange: String,
                         test_stat: String,
                         p_value: Double,
                         q_value: Double,
                         significant: String
                        )

  val parser = CsvParser(DiffExpress)

  //protected def read(list: List[String]): StringReader = readStr( list.tail.reduce(_+_) )
  protected def readStr(str: String): StringReader = new java.io.StringReader(str)
  //def load(path: String, withHeaders: Boolean = true) = parser.parse(read(Source.fromFile(new File(path)).getLines().toList), "\t")
  //def readLines(path: String) = Source.fromFile(new File(path)).getLines().toList.tail.reduce(_ + _)
  def readFile(path: String) = parser.parse(readStr(Source.fromFile(path).getLines().toList.tail.mkString("\n")), "\t")

}