package com.mrowacz

import org.apache.spark.sql.SparkSession

package object sparkdemo {
  def createSparkSession(appName: String, isLocal: Boolean): SparkSession = {
    if (isLocal) {
      SparkSession
        .builder()
        .config("spark.sql.caseSensitive", value = true)
        .config("spark.sql.session.timeZone", value = "UTC")
        .config("spark.driver.memory", value = "8G")
        .appName(appName)
        .master("local[*]")
        .getOrCreate()
    } else {
      SparkSession
        .builder()
        .config("spark.sql.caseSensitive", value = true)
        .config("spark.sql.session.timeZone", value = "UTC")
        .appName(appName)
        .getOrCreate()
    }
  }

  def parseArgs(args: Array[String]): (String, String) = {
//    val parsedArgs = args.map(arg => arg.split(" ")).map(splitArg => splitArg(0) -> splitArg(1)).toMap
//    val inputPath = parsedArgs("--input-path")
//    val outputPath = parsedArgs("--output-path")
    val inputPath = args(1)
    val outputPath = args(3)

    println(s"input path: ${inputPath}")
    println(s"output path: ${outputPath}")

    (inputPath, outputPath)
  }
}
