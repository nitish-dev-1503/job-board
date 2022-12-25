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

    public void removeJob(Job job) {
        jobs.remove(job);
    }

    public List<Job> getJobsByKeywordInTitle(String keyword) {
        return jobs.stream().filter(job -> {
            var jobTitle = job.getTitle().toLowerCase();
            return jobTitle.contains(keyword.toLowerCase());
        }).toList();
    }

    public List<Job> getJobsByLocation(String location) {
        return jobs.stream().filter(job -> job.getLocation().equals(location)).toList();
    }
}
