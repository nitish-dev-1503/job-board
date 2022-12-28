package com.connect.jobboard.domain;

import java.util.UUID;

public class Job {
    private final UUID id;
    private final String title;
    private final String location;

    public Job(String title, String location) {
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
