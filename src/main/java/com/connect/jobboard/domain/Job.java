package com.connect.jobboard.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Job {
    private final UUID id;
    private final String title;
    private final String location;

    @JsonCreator
    public Job(@JsonProperty("title") String title, @JsonProperty("location") String location) {
        this.title = title;
        this.location = location;
        id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }
}
