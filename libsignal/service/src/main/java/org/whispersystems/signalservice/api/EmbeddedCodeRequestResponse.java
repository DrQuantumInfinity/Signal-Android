package org.whispersystems.signalservice.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmbeddedCodeRequestResponse {
    @JsonProperty("code")
    int code;

    @JsonCreator
    public EmbeddedCodeRequestResponse(@JsonProperty("code") int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
