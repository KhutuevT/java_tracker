package com.backand.tracker.modules.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class ProjectRestControllerV1Test {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        System.out.println("---SetUp---");
    }

    @AfterEach
    void tearDown() {
        System.out.println("---TearDown---");
    }

    @Test
    @WithMockUser(username = "timon", password = "timon")
    void getById() throws Exception {
        this.mockMvc
                .perform(get("/api/v1/projects/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content()
                        .json("{\"name\":\"Test\",\"descriptions\":\"Test\",\"creatorId\":1,\"tasks\":[],\"userProjects\":[],\"projectRoles\":[]}"));
    }

    @Test
    @WithMockUser(username = "timon", password = "timon")
    void createNewProject() throws Exception {
        this.mockMvc
                .perform(post("/api/v1/projects")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Test2\",\"descriptions\":\"Test\"}") //TODO удалять надо
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "timon", password = "timon")
    void deleteProject() {
    }

    @Test
    @WithMockUser(username = "timon", password = "timon")
    void addEmployeeInProject() {
    }

    @Test
    @WithMockUser(username = "timon", password = "timon")
    void deleteEmployeeInProject() {
    }
}