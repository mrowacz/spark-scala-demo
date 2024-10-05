package com.mrowacz.sparkdemo

import com.mrowacz.sparkdemo.Analysis.calculateAverageTipByPickupLocation

object SparkExampleMain extends App {
  val spark = createSparkSession("Spark test", isLocal = false)

  val (inputPath, outputPath) = parseArgs(args = args)
  val data = spark.read.parquet(s"${inputPath}/*.parquet")

  val analysisResult = calculateAverageTipByPickupLocation(data = data)

  analysisResult.write.option("header", "true").mode("overwrite").csv(outputPath)
  Thread.sleep(100000000)
}