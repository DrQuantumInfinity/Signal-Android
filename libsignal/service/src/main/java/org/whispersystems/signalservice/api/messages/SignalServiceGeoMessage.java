package org.whispersystems.signalservice.api.messages;

public class SignalServiceGeoMessage {
  Type type;
  String name;              // Name of the geo area, or coordinate URL of a map tile / overlay
  int notBeforeUtc;      // Validity period start in UTC seconds, immediate if 0
  int notAfterUtc;       // Validity period end in UTC seconds, for eternity if 0
  String authorizationUri;  // URI to retrieve authentication for payload from (optional)
  String cekUri;            // URI to retrieve content encryption key from (optional)
  int payloadLength;     // Payload length in bytes
  byte[] payloadData;       // Payload data

  public SignalServiceGeoMessage(Type type, String name, int notBeforeUtc, int notAfterUtc, String authorizationUri, String cekUri, int payloadLength, byte[] payloadData) {
    this.type = type;
    this.name = name;
    this.notBeforeUtc = notBeforeUtc;
    this.notAfterUtc = notAfterUtc;
    this.authorizationUri = authorizationUri;
    this.cekUri = cekUri;
    this.payloadLength = payloadLength;
    this.payloadData = payloadData;
  }

  public Type getType() {
    return type;
  }

  public String getName() {
    return name;
  }

  public int getNotBeforeUtc() {
    return notBeforeUtc;
  }

  public int getNotAfterUtc() {
    return notAfterUtc;
  }

  public String getAuthorizationUri() {
    return authorizationUri;
  }

  public String getCekUri() {
    return cekUri;
  }

  public int getPayloadLength() {
    return payloadLength;
  }

  public byte[] getPayloadData() {
    return payloadData;
  }

  public enum Type {
    GEO_KML_DATA,
    GEO_JSON_DATA,
    GEO_IMAGE_DATA
  }
}
