package com.gmaslowski.telemetry

import akka.actor.{Actor, ActorLogging, ActorRef, Props}
import akka.util.ByteString
import com.gmaslowski.telemetry.live.model.TelemetryModel

object TelemetryReceiver {
  def props(changesHandler: ActorRef) = Props(classOf[TelemetryReceiver], changesHandler)
}

// todo: fix the name to actually mean what it does
class TelemetryReceiver(val changesHandler: ActorRef) extends Actor with ActorLogging {

  val telemetryModel = context.actorOf(TelemetryModel.props(changesHandler))

  override def receive = {
    case packet: ByteString =>
      telemetryModel ! packet
  }
}