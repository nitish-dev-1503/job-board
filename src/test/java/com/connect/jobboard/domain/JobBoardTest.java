package com.connect.jobboard.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JobBoardTest {

    @Test
    void shouldAddNewJob() {
        var job = new Job("Software Engineer");
        var jobBoard = new JobBoard();

        jobBoard.addJob(job);

        assertEquals(1, jobBoard.getJobs().size());
        assertTrue(jobBoard.getJobs().contains(job));
    }

    @Test
    void shouldReturnAllJobs() {
        var jobTitle = "Software Engineer";
        var job = new Job(jobTitle);
        var jobBoard = new JobBoard();
        jobBoard.addJob(job);

        var jobs = jobBoard.getJobs();

        assertEquals(jobTitle, jobs.get(0).getTitle());
    }
}