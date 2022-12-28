package com.connect.jobboard.controller;

import com.connect.jobboard.domain.Job;
import com.connect.jobboard.domain.JobBoard;
import com.connect.jobboard.service.JobBoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(JobBoardController.class)
class JobBoardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JobBoardService jobBoardService;

    @Test
    void shouldCallJobBoardServiceToGetJobBoard() throws Exception {
        when(jobBoardService.getJobBoard()).thenReturn(getJobBoard());

        mockMvc.perform(get("/api/jobBoard").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(getJobBoardJsonResponse()));
    }

    private JobBoard getJobBoard() {
        JobBoard jobBoard = new JobBoard();
        jobBoard.addJob(new Job("Frontend Developer", "Mumbai"));
        return jobBoard;
    }

    private String getJobBoardJsonResponse() {
        return """
                {
                    "count":1,
                    "jobs":[
                        {
                            "title":"Frontend Developer",
                            "location":"Mumbai"
                        }
                    ]
                }
                """;
    }
}