package com.knoldus

import java.util.Properties
import org.apache.kafka.clients.producer._

class Producer {

  def main(args: Array[String]): Unit = {
    writeToKafka("test")
  }

  def writeToKafka(topic: String): Unit = {
    val props = new Properties()
    props.put("bootstrap.servers", "localhost:9099")
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", classOf[CustomSerializer])
    val producer = new KafkaProducer[String, User](props)
    val userObject = User(2, "asdas", "sadasd")
    println("inside prducer")

    val user = "user"
    val message = "message"

    for (i <- 1 to 5) {
      val record = new ProducerRecord[String, User](topic, s"i", User(i, s"$user + $i", s"$message + $i"))
      producer.send(record)
    }

    //val record = new ProducerRecord[String, User](topic, "User2", userObject)
    //producer.send(record)
    //println(" prducer send complete")
    println("producer complete")
    producer.close()
  }
}


