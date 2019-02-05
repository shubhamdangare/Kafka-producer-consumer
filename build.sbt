name := "KafkaWordCount"

version := "0.1"

scalaVersion := "2.11.7"


lazy val root = (project in file("."))
  .settings(
    name := "root",
    libraryDependencies ++= Seq("org.apache.kafka" %% "kafka" % "0.11.0.0","org.apache.kafka"%"kafka-clients"%"0.10.2.1")
  )