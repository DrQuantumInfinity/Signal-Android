package org.whispersystems.signalservice.api.messages;

public class LocationMessage {

  private long timestamp;
  private double latitude;
  private double longitude;
  private double altitude;
  private float speed;
  private float course;
  private float horizontalAccuracy;
  private float verticalAccuracy;

  public long getTimestamp() {
    return timestamp;
  }

  public double getLatitude() {
    return latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public double getAltitude() {
    return altitude;
  }

  public float getSpeed() {
    return speed;
  }

  public float getCourse() {
    return course;
  }

  public float getHorizontalAccuracy() {
    return horizontalAccuracy;
  }

  public float getVerticalAccuracy() {
    return verticalAccuracy;
  }

  public LocationMessage(long timestamp,
                                      double latitude,
                                      double longitude,
                                      double altitude,
                                      float speed,
                                      float course,
                                      float horizontalAccuracy,
                                      float verticalAccuracy) {
    this.timestamp = timestamp;
    this.latitude = latitude;
    this.longitude = longitude;
    this.altitude = altitude;
    this.speed = speed;
    this.course = course;
    this.horizontalAccuracy = horizontalAccuracy;
    this.verticalAccuracy = verticalAccuracy;
  }
}
