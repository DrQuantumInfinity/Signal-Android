package org.whispersystems.signalservice.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class AutoGroupRequestResponse {
    @JsonProperty("configs")
    ArrayList<AutoGroupConfig> configs;

    @JsonCreator
    public AutoGroupRequestResponse(@JsonProperty("configs") ArrayList<AutoGroupConfig> configs) {
        this.configs = configs;
    }

    public ArrayList<AutoGroupConfig> getConfigs() {
        return configs;
    }

    public class AutoGroupConfig {
        @JsonProperty("members")
        ArrayList<String> members;

        @JsonProperty("topic")
        String topic;

        @JsonProperty("groupName")
        String groupName;

        public ArrayList<String> getMembers() {
            return members;
        }

        public String getTopic() {
            return topic;
        }

        public String getGroupName() {
            return groupName;
        }

        @JsonCreator
        public AutoGroupConfig(@JsonProperty("members") ArrayList<String> members, @JsonProperty("topic") String topic, @JsonProperty("groupName") String groupName) {
            this.members = members;
            this.topic = topic;
            this.groupName = groupName;
        }
    }
}
