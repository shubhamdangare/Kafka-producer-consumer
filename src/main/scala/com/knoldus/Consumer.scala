package com.knoldus

import java.util

import org.apache.kafka.clients.consumer.KafkaConsumer
import java.util.Properties

import scala.collection.JavaConverters._

object Consumer extends App {

  val  props = new Properties()
  props.put("bootstrap.servers", "localhost:9092")
  props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  props.put("value.deserializer",classOf[CustomDeserializer])
  props.put("group.id", "user-data8")

  val consumer = new KafkaConsumer[String, User](props)
  consumer.subscribe(util.Arrays.asList("user-test8"))
  println("hi from consumer")
  while(true){
    val record = consumer.poll(100).asScala
    for (data <- record.iterator){
      println(data.value())
      println("inside consumer")
    }
  }
  consumer.close()
}