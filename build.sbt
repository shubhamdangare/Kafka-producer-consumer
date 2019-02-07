name := "KafkaWordCount"

version := "0.1"

scalaVersion := "2.12.8"


lazy val root = (project in file("."))
  .settings(
    name := "root",
    libraryDependencies ++= Seq("org.apache.kafka" %% "kafka" % "2.0.0",
      "com.fasterxml.jackson.core" % "jackson-core" % "2.9.8",
      "com.fasterxml.jackson.core" % "jackson-annotations" % "2.9.8",
      "com.fasterxml.jackson.core" % "jackson-databind" % "2.9.8",
      "com.typesafe.play" %% "play-json" % "2.7.1",
      "de.heikoseeberger" %% "akka-http-play-json"   % "1.20.0",
      "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.9.8",
      "net.manub" %% "scalatest-embedded-kafka" % "0.14.0" % "test"
    )
  )