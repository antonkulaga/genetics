package org.denigma.genetics

import java.nio.file.Paths

import org.denigma.genetics.expressions.CuffDiff

/**
  * Created by antonkulaga on 12/4/16.
  */
object Main extends scala.App{
  val wd = System.getProperty("user.dir")
  val wd2 =  Paths.get("").toAbsolutePath
  println(s"Hello world from ${wd}!")
  //println(s"Hello world from ${wd2}!")

  val files = "/home/antonkulaga/denigma/genetics"
  val test = s"${files}/files/test"
  val testFile = s"${test}/gene_exp.diff"
  /*
  val result = CuffDiff.load(testFile)
  val first = result.head
  val last = result.last
  println(s"first ${first}")
  println(s"last ${last}")
  */
  //val result = CuffDiff.load(testFile)
  val p = CuffDiff.parser
  val result = CuffDiff.readFile(testFile)
  result.foreach(r => println(r))
}
