package com.connect.jobboard.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void shouldRemoveAJob() {
        var job = new Job("Software Engineer");
        var jobBoard = new JobBoard();
        jobBoard.addJob(job);

        jobBoard.removeJob(job);

        assertFalse(jobBoard.getJobs().contains(job));
    }

    @Test
    void shouldReturnJobFilteredByTitle() {
        var software_engineer = "Software Engineer";
        var job1 = new Job(software_engineer);
        var job2 = new Job("UX Engineer");
        var jobBoard = new JobBoard();
        jobBoard.addJob(job1);
        jobBoard.addJob(job2);

        var jobsByTitle = jobBoard.getJobsByKeywordInTitle(software_engineer);

        assertTrue(jobsByTitle.contains(job1));
        assertEquals(software_engineer, jobsByTitle.get(0).getTitle());
    }

    @Test
    void shouldReturnJobFilteredByKeywordInTitle() {
        var job1 = new Job("Software Engineer");
        var job2 = new Job("UX Engineer");
        var jobBoard = new JobBoard();
        jobBoard.addJob(job1);
        jobBoard.addJob(job2);

        var jobsByTitle = jobBoard.getJobsByKeywordInTitle("Engineer");

        assertTrue(jobsByTitle.contains(job1));
        assertTrue(jobsByTitle.contains(job2));
    }
}