package org.whispersystems.signalservice.api.messages;

import org.whispersystems.libsignal.util.guava.Optional;

public class SignalServiceBaCommandMessage {

  private final Type type;
  private final long timestamp;
  private final PullReq pullReq;
  private final Status status;
  private final Optional<LocationMessage> locationMessage;
  private final Optional<ZmqTopicMessage> zmqMessage;

  private SignalServiceBaCommandMessage(Type type, long timestamp, PullReq pullReq, Status status, Optional<LocationMessage> locationMessage, Optional<ZmqTopicMessage> zmqMessage) {
    this.type = type;
    this.timestamp = timestamp;
    this.pullReq = pullReq;
    this.status = status;
    this.locationMessage = locationMessage;
    this.zmqMessage = zmqMessage;
  }

  public static SignalServiceBaCommandMessage forLocation(long timestamp, LocationMessage locationMessage) {
    return new SignalServiceBaCommandMessage(Type.PUSH, timestamp, PullReq.LOCATION, Status.OK, Optional.of(locationMessage), Optional.absent());
  }

  public static SignalServiceBaCommandMessage forZmq(long timestamp, ZmqTopicMessage zmqTopicMessage) {
    return new SignalServiceBaCommandMessage(Type.PULL, timestamp, PullReq.LOCATION, Status.OK, Optional.absent(), Optional.of(zmqTopicMessage));
  }

  public static SignalServiceBaCommandMessage forRejection(long timestamp, Status status, PullReq pullReq) {
    return new SignalServiceBaCommandMessage(Type.PUSH, timestamp, pullReq, status, Optional.<LocationMessage>absent(), Optional.absent());
  }

  public static SignalServiceBaCommandMessage forLocationRequest(long timestamp) {
    return new SignalServiceBaCommandMessage(Type.PULL, timestamp, PullReq.LOCATION, Status.OMITTED, Optional.<LocationMessage>absent(), Optional.absent());
  }

  public static SignalServiceBaCommandMessage empty() {
    return new SignalServiceBaCommandMessage(Type.PULL, 0, PullReq.EMPTY, Status.OMITTED, Optional.<LocationMessage>absent(), Optional.absent());
  }

  public Optional<LocationMessage> getLocation() {
    return locationMessage;
  }

  public Optional<ZmqTopicMessage> getZmqMessage() {
    return zmqMessage;
  }

  public Type getType() {
    return type;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public PullReq getPullReq() {
    return pullReq;
  }

  public Status getStatus() {
    return status;
  }

  public enum Type {
    PULL, PUSH
  }

  public enum PullReq { //this can be extended to support any number of categories of actions
    EMPTY,    //respond with a null payload
    LOCATION, //respond with a LocationMessage
    ZMQ_TOPIC //forward messages matching this topic to sender from now on
  }

  public enum Status {
    OK,
    TIMEOUT, //stale command received and will not be serviced (note this is provisioned but use is not yet required to be used for LOCATION)
    UNSUPPORTED, //protocol versions not compatible
    UNAUTHORIZED,  //requested action is disabled in settings for requester or globally
    OMITTED
  }
}
