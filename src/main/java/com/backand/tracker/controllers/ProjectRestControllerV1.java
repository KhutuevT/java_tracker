package com.backand.tracker.controllers;

import com.backand.tracker.domains.project.Project;
import com.backand.tracker.domains.user.User;
import com.backand.tracker.dtos.req.CreateProjectReqDto;
import com.backand.tracker.repositories.UserRepository;
import com.backand.tracker.security.jwt.JwtUser;
import com.backand.tracker.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
    public ResponseEntity getById(@PathVariable Long projectId, Principal principal) {
        User user = userRepository.findByUsername(principal.getName()).get();
        Project project = projectService.getById(user, projectId);
        return new ResponseEntity(project, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity createNewProject(@RequestBody CreateProjectReqDto reqDto, Principal principal) {
        User user = userRepository.findByUsername(principal.getName()).get();
        Project project = projectService.createNewProject(user, reqDto.getName(), reqDto.getDescriptions());
        return new ResponseEntity(project, HttpStatus.OK);
    }

    @PostMapping("/employee")
    public ResponseEntity addEmployeeInProject() {
        return null;
    }

    @DeleteMapping("/employee")
    public ResponseEntity deleteEmployeeInProject() {
        return null;
    }
}
