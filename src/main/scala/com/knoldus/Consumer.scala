package com.knoldus

import java.time.Duration
import java.util

import org.apache.kafka.clients.consumer.KafkaConsumer
import java.util.Properties

import scala.collection.JavaConverters._

class Consumer {

  def main(args: Array[String]): Unit = {
    consumeFromKafka("test2")
  }

  def consumeFromKafka(topic: String) = {
    val props = new Properties()
    props.put("bootstrap.servers", "localhost:9094")
    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.put("value.deserializer", classOf[CustomDeserializer])
    // import java.util.UUID
    // props.put("group.id", UUID.randomUUID.toString)
    props.put("auto.offset.reset", "latest")
    props.put("group.id", "consumer-group")
    println("inside consumer")
    val consumer: KafkaConsumer[String, User] = new KafkaConsumer[String, User](props)
    consumer.subscribe(util.Arrays.asList("test8"))
    println("inside subscriber")
    while (true) {
      print("enter")
      val record = consumer.poll(Duration.ZERO).asScala.iterator
      println("true")
      println(record)
      for (value <- record)
        println(value)
    }

    /**
      * val record = consumer.poll(100000).asScala.toList.map(_.value())
      * println("consumer record data is")
      * println(record)
      * println("consumer Done")
      * record
      */
  }
}