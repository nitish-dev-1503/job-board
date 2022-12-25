package com.connect.jobboard.domain;

import java.util.ArrayList;
import java.util.List;

public class JobBoard {
    private final List<Job> jobs;

    public JobBoard() {
        this.jobs = new ArrayList<>();
    }

    public void addJob(Job job) {
        jobs.add(job);
    }

    public List<Job> getJobs() {
        return jobs;
    }
}
