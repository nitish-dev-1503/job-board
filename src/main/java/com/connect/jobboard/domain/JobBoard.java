package com.connect.jobboard.domain;

import java.util.ArrayList;
import java.util.List;

public class JobBoard {
    private final List<Job> jobs;
    private Integer count;

    public JobBoard() {
        this.jobs = new ArrayList<>();
        this.count = 0;
    }

    public void addJob(Job job) {
        jobs.add(job);
        count++;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Job> getJobs() {
        return jobs;
    }
}
