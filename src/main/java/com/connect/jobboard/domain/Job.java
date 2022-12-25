package com.connect.jobboard.domain;

public class Job {
    private final String title;
    private final String location;

    public Job(String title, String location) {
        this.title = title;
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }
}
