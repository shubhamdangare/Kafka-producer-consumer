package com.knoldus

import java.util

import org.apache.kafka.common.serialization.Deserializer
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule


class CustomDeserializer extends Deserializer[User] {

  override def configure(configs: util.Map[String, _], isKey: Boolean): Unit = {
  }

  override def deserialize(topic: String, bytes: Array[Byte]): User = {

    try {
      val mapper = new ObjectMapper
      mapper.registerModule(DefaultScalaModule)
      //      print(bytes,toString)
      mapper.readValue(bytes, classOf[User])
    }
    catch {
      case ex: Exception => throw new Exception(ex.getMessage)
    }
  }

  override def close(): Unit = {

  }

}
