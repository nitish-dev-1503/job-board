package com.connect.jobboard.service;

import com.connect.jobboard.domain.JobBoard;
import com.connect.jobboard.repository.JobBoardRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JobBoardServiceTest {

    @Mock
    private JobBoardRepository jobBoardRepository;

    @InjectMocks
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