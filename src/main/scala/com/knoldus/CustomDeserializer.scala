package com.knoldus

import java.io.{ByteArrayInputStream, ObjectInputStream}
import java.util

import org.apache.kafka.common.serialization.Deserializer
import com.fasterxml.jackson.databind.ObjectMapper


class CustomDeserializer extends Deserializer[User] {

  override def configure(configs: util.Map[String, _], isKey: Boolean): Unit = {
  }

  override def deserialize(topic: String, bytes: Array[Byte]): User = {

    try {
      val mapper = new ObjectMapper
      mapper.readValue(bytes, classOf[User])
    }
    catch {
      case ex: Exception => throw new Exception(ex.getMessage)
    }

    /** val byteIn = new ByteArrayInputStream(bytes)
      * val objIn = new ObjectInputStream(byteIn)
      * val obj = objIn.readObject().asInstanceOf[User]
      *byteIn.close()
      *objIn.close()
      * obj
      */
  }

  override def close(): Unit = {

  }

}
