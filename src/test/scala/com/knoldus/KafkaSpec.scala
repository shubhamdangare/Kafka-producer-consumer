package com.knoldus

import java.util


import net.manub.embeddedkafka.{EmbeddedKafka, EmbeddedKafkaConfig}
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import org.scalatest.{BeforeAndAfterAll, FlatSpec, WordSpec}
class KafkaSpec extends FlatSpec with EmbeddedKafka with BeforeAndAfterAll{

  val topic = "test-topic"
  val producer = new Producer
  val consumer = new Consumer
  implicit val config = EmbeddedKafkaConfig(kafkaPort = 9092, zooKeeperPort = 2181)


  override def beforeAll(): Unit = {
    EmbeddedKafka.start()
  }

  it should "publish synchronously data to kafka" in {
    val response = consumeFirstStringMessageFrom(topic)
    assert(Some(response).isDefined)
  }

  override def afterAll(): Unit = {
    EmbeddedKafka.stop()
  }

}
