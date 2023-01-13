package com.backand.tracker.modules.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.FileInputStream;

@SpringBootTest
@AutoConfigureMockMvc

@TestPropertySource(locations = "classpath:application-test.properties")
@Sql(value = "/sql/delete-all.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/sql/create-user-before.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/sql/create-project-before.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)

@AutoConfigureRestDocs(outputDir = "build/generated-snippets")
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
                .andDo(document("{class-name}/{method-name}",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())))
                .andExpect(status().isOk())
                .andExpect(content()
                        .json("{\"name\":\"test\",\"descriptions\":\"test\",\"creatorId\":1,\"tasks\":[],\"userProjects\":[],\"projectRoles\":[]}"));
    }

    @Test
    @WithMockUser(username = "timon", password = "timon")
    void createNewProject() throws Exception {
        //        this.mockMvc
//                .perform(post("/api/v1/projects")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"name\":\"Test2\",\"descriptions\":\"Test\"}")
//                        .accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andDo(document("{class-name}/{method-name}",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint())))
//                .andExpect(status().isOk())
//                .andExpect(content()
//                        .json("{\"name\":\"Test2\",\"descriptions\":\"Test\",\"creatorId\":1,\"tasks\":null,\"userProjects\":null,\"projectRoles\":null}"));
    }

//    @Test
//    @WithMockUser(username = "timon", password = "timon")
//    void deleteProject() {
//    }
//
//    @Test
//    @WithMockUser(username = "timon", password = "timon")
//    void addEmployeeInProject() {
//    }
//
//    @Test
//    @WithMockUser(username = "timon", password = "timon")
//    void deleteEmployeeInProject() {
//    }
}