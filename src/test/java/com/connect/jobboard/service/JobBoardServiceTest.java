package com.connect.jobboard.service;

import com.connect.jobboard.domain.JobBoard;
import com.connect.jobboard.repository.JobBoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class JobBoardServiceTest {

    @MockBean
    private JobBoardRepository jobBoardRepository;

    @Autowired
    private JobBoardService jobBoardService;

    @Test
    void shouldCallJobBoardRepositoryToGetJobBoard() {
        jobBoardService.getJobBoard();

        verify(jobBoardRepository).getJobBoard();
    }

    @Test
    void shouldReturnAJobBoard() {
        var expectedJobBoard = new JobBoard();
        when(jobBoardRepository.getJobBoard()).thenReturn(expectedJobBoard);

        var actualJobBoard = jobBoardService.getJobBoard();

        assertEquals(expectedJobBoard, actualJobBoard);
    }
}