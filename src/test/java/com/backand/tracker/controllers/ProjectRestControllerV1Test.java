package com.backand.tracker.controllers;

import com.backand.tracker.services.ProjectService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProjectRestControllerV1Test {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProjectService projectService;

    @BeforeEach
    void setUp() {
        System.out.println("SetUp");
    }

    @AfterEach
    void tearDown() {
        System.out.println("TearDown");
    }

    @Test
    @WithMockUser(username = "test", password = "test")
    void getById() throws Exception {
        this.mockMvc
                .perform(get("/api/v1/projects/1"))
                .andDo(print())
                .andExpect(status().isOk());
                //.andExpect(content().json("{}"));
    }

    @Test
    void test() throws Exception {
        this.mockMvc
                .perform(get("/api/v1/projects/test"))
                .andDo(print())
                .andExpect(status().isForbidden());
    }
}