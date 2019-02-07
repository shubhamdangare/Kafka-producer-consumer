package com.knoldus

import net.manub.embeddedkafka.{EmbeddedKafka, EmbeddedKafkaConfig}
import org.apache.kafka.common.serialization.{Serdes, StringSerializer}
import org.scalatest.{BeforeAndAfterAll, WordSpec}

class KafkaSpec extends WordSpec with EmbeddedKafka with BeforeAndAfterAll {

  val topic = "test-v111"
  //  val producer = new Producer
  //  val consumer = new Consumer
  implicit val config = EmbeddedKafkaConfig(kafkaPort = 9092, zooKeeperPort = 2181)
  implicit val serializer = Serdes.String().serializer()
  implicit val deserializer=Serdes.String().deserializer()
  "runs with embedded kafka" should {

    "work" in {
      withRunningKafka {
        EmbeddedKafka.publishToKafka(topic, "test test")
        //        producer.writeToKafka(topic)
        println("zcfd"+EmbeddedKafka.consumeFirstStringMessageFrom(topic).isEmpty)
//        Consumer.consumeFromKafka(topic)

      }
    }

  }
}
