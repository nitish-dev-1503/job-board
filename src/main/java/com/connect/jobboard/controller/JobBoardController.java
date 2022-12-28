package com.connect.jobboard.controller;

import com.connect.jobboard.domain.JobBoard;
import com.connect.jobboard.service.JobBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobBoardController {

    @Autowired
    private JobBoardService jobBoardService;

    @GetMapping("/api/jobBoard")
    public JobBoard getJobBoard() {
        return jobBoardService.getJobBoard();
    }
}
