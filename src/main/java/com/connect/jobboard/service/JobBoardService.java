package com.connect.jobboard.service;

import com.connect.jobboard.domain.JobBoard;
import com.connect.jobboard.repository.JobBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobBoardService {

    @Autowired
    private JobBoardRepository jobBoardRepository;

    public JobBoard getJobBoard() {
        return jobBoardRepository.getJobBoard();
    }
}
