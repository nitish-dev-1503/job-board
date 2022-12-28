package com.connect.jobboard.repository;

import com.connect.jobboard.domain.Job;
import com.connect.jobboard.domain.JobBoard;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JobBoardRepository {

    private static final Logger logger = LoggerFactory.getLogger(JobBoardRepository.class);
    public static final String JOB_JSON = "src/main/resources/data/Job.json";

    public JobBoard getJobBoard() {
        var jobBoard = new JobBoard();
        var jobs = getJobs();
        jobs.forEach(jobBoard::addJob);
        jobBoard.setCount(jobs.size());

        return jobBoard;
    }

    private List<Job> getJobs() {
        var objectMapper = new ObjectMapper();
        var jobs = new ArrayList<Job>();
        try {
            var jsonFile = new File(JOB_JSON);
            jobs = objectMapper.readValue(jsonFile, new TypeReference<>() {
            });
        } catch (IOException e) {
            logger.error("Unable to load jobs from {}", JOB_JSON);
        }
        return jobs;
    }
}
