package org.whispersystems.signalservice.api.messages;

import org.whispersystems.libsignal.util.guava.Optional;

public class SignalServiceBaCommandMessage {

  private final Type type;
  private final long timestamp;
  private final PullReq pullReq;
  private final Status status;
  private final Optional<LocationMessage> locationMessage;

  private SignalServiceBaCommandMessage(Type type, long timestamp, PullReq pullReq, Status status, Optional<LocationMessage> locationMessage) {
    this.type = type;
    this.timestamp = timestamp;
    this.pullReq = pullReq;
    this.status = status;
    this.locationMessage = locationMessage;
  }

  public static SignalServiceBaCommandMessage forLocation(long timestamp, LocationMessage locationMessage) {
    return new SignalServiceBaCommandMessage(Type.PUSH, timestamp, PullReq.LOCATION, Status.OK, Optional.of(locationMessage));
  }

  public static SignalServiceBaCommandMessage forRejection(long timestamp, Status status, PullReq pullReq) {
    return new SignalServiceBaCommandMessage(Type.PUSH, timestamp, pullReq, status, Optional.<LocationMessage>absent());
  }

  public static SignalServiceBaCommandMessage forLocationRequest(long timestamp) {
    return new SignalServiceBaCommandMessage(Type.PULL, timestamp, PullReq.LOCATION, Status.OMITTED, Optional.<LocationMessage>absent());
  }

  public static SignalServiceBaCommandMessage empty() {
    return new SignalServiceBaCommandMessage(Type.PULL, 0, PullReq.EMPTY, Status.OMITTED, Optional.<LocationMessage>absent());
  }

  public Optional<LocationMessage> getLocation() {
    return locationMessage;
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
    LOCATION //respond with a LocationMessage
  }

  public enum Status {
    OK,
    TIMEOUT, //stale command received and will not be serviced (note this is provisioned but use is not yet required to be used for LOCATION)
    UNSUPPORTED, //protocol versions not compatible
    UNAUTHORIZED,  //requested action is disabled in settings for requester or globally
    OMITTED
  }

//  public Action getAction() {
//    return action;
//  }
//
//  public Optional<byte[]> getGroupId() {
//    return groupId;
//  }
//
//  public boolean isTypingStarted() {
//    return action == Action.STARTED;
//  }
//
//  public boolean isTypingStopped() {
//    return action == Action.STOPPED;
//  }
}
