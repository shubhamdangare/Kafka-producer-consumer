package com.knoldus

import java.util.Properties
import org.apache.kafka.clients.producer._

class Producer extends App {

  val  props = new Properties()
  props.put("bootstrap.servers", "localhost:9092")
  props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer", classOf[CustomSerializer])

  val producer = new KafkaProducer[String, User](props)

  val userObject =  User(2,"asdas","sadasd")
  val record = new ProducerRecord[String,User]("user-test8", "User2", userObject)
  producer.send(record)
  producer.close()
}