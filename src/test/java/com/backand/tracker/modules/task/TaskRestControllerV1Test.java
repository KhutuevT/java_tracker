package com.backand.tracker.modules.task;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc

@TestPropertySource(locations = "classpath:application-test.properties")
@Sql(value = "/sql/delete-all.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/sql/create-user-before.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/sql/create-project-before.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/sql/create-task-before.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class TaskRestControllerV1Test {

    @Autowired
    private MockMvc mockMvc;

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
    void getByProjectId() throws Exception {
        this.mockMvc
                .perform(get("/api/v1/projects/1/tasks"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content()
                        .json("[{\"name\":\"test\",\"description\":\"test\",\"projectId\":1,\"creatorId\":1,\"timeSlices\":[],\"userTasks\":[],\"taskRoles\":[]}]"));
    }

    @Test
    @WithMockUser(username = "timon", password = "timon")
    void getById() throws Exception {
        this.mockMvc
                .perform(get("/api/v1/projects/1/tasks/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content()
                        .json("{\"name\":\"test\",\"description\":\"test\",\"projectId\":1,\"creatorId\":1,\"timeSlices\":[],\"userTasks\":[],\"taskRoles\":[]}"));
    }

    @Test
    @WithMockUser(username = "timon", password = "timon")
    void add() throws Exception {
        this.mockMvc
                .perform(post("/api/v1/projects/1/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Test2\",\"descriptions\":\"Test\"}")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content()
                        .json("{\"name\":\"Test2\",\"description\":\"Test\",\"projectId\":1,\"creatorId\":1,\"timeSlices\":null,\"userTasks\":null,\"taskRoles\":null}"));
    }
}