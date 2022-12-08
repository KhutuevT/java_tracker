package com.backand.tracker.modules.project;

import com.backand.tracker.modules.project.service.ProjectService;
import com.backand.tracker.modules.user.User;
import com.backand.tracker.modules.project.dto.req.CreateProjectReqDto;
import com.backand.tracker.modules.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping(value = "/api/v1/projects")
public class ProjectRestControllerV1 {

    ProjectService projectService;
    UserRepository userRepository;

    @Autowired
    ProjectRestControllerV1(
            ProjectService projectService,
            UserRepository userRepository
    ) {
        this.projectService = projectService;
        this.userRepository = userRepository;
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<Project> getById(
            @PathVariable
            Long projectId,
            Principal principal
    ) {
        User user = userRepository
                .findByUsername(principal.getName())
                .get();

        Project project = projectService
                .getById(user, projectId);

        return new ResponseEntity<Project>(project, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Project> createNewProject(
            @RequestBody
            CreateProjectReqDto reqDto,
            Principal principal
    ) {
        User user = userRepository
                .findByUsername(principal.getName())
                .get();

        Project project = projectService
                .createNewProject(
                        user, reqDto.getName(), reqDto.getDescriptions());

        return new ResponseEntity<Project>(project, HttpStatus.OK);
    }

//    @PostMapping("/employee")
//    public ResponseEntity addEmployeeInProject() {
//        return null;
//    }
//
//    @DeleteMapping("/employee")
//    public ResponseEntity deleteEmployeeInProject() {
//        return null;
//    }
}
