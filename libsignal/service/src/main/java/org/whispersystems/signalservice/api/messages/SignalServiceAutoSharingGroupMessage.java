package org.whispersystems.signalservice.api.messages;

public class SignalServiceAutoSharingGroupMessage {
    byte[] payload;       // Payload

    public SignalServiceAutoSharingGroupMessage(byte[] payload) {
        this.payload = payload;
    }

    public byte[] getPayload() {
        return payload;
    }
}
