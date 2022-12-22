package com.backand.tracker.modules.project;

import com.backand.tracker.modules.auth.services.AuthService;
import com.backand.tracker.modules.project.service.ProjectService;
import com.backand.tracker.modules.user.User;
import com.backand.tracker.modules.user.primitives.EmailAddress;
import com.backand.tracker.modules.user.primitives.Password;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;


import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProjectRestControllerV1Test {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ProjectMapper projectMapper;

    @MockBean
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectService projectService;

    @MockBean
    private AuthService authService;


    //    @MockBean
//    private UserRepository userRepository;
//
//    @MockBean
//    private ProjectRolePermissionsService projectRolePermissionsService;
//
//    @MockBean
//    private TaskService taskService;
//
//    @MockBean
//    private TaskRoleService taskRoleService;
//
//    @MockBean
//    private TaskRolePermissionsService taskRolePermissionsService;
//
//    @MockBean
//    private UserProjectService userProjectService;
//
//    @MockBean
//    private UserTaskService userTaskService;
//
//    @MockBean
//    private TimeSliceService timeSliceService;
//
//    @MockBean
//    private ProjectService projectService;


//    @MockBean
//    private UserService userService;
//
//    @MockBean
//    private ProjectRoleService projectRoleService;

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
        EmailAddress testEmail = new EmailAddress("test@test.test");
        Password testPassword = new Password("testPassword");
        User testUser = new User("TestName", testEmail, testPassword);
        Project project = new Project("TestName", "TestDesc", testUser);

        Mockito.when(projectRepository.getProjectById(Mockito.any())).thenReturn(Optional.of(project));

        this.mockMvc
                .perform(get("/api/v1/projects/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "timon", password = "timon")
    void createNewProject() {
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