package com.backand.tracker.modules.project;

import com.backand.tracker.modules.project.dto.res.ProjectDto;
import com.backand.tracker.modules.project.service.ProjectService;
import com.backand.tracker.modules.user.User;
import com.backand.tracker.modules.project.dto.req.CreateProjectReqDto;
import com.backand.tracker.modules.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping(value = "/api/v1/projects")
public class ProjectRestControllerV1 {

    UserService userService;
    ProjectService projectService;

    @Autowired
    ProjectRestControllerV1(
            ProjectService projectService,
            UserService userService
    ) {
        this.projectService = projectService;
        this.userService = userService;
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<ProjectDto> getById(
            @PathVariable
            Long projectId,
            Principal principal
    ) {
        User user = userService.getUserByUsername(principal.getName());

        ProjectDto project = projectService
                .getById(user, projectId);

        return new ResponseEntity<ProjectDto>(project, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ProjectDto> createNewProject(
            @RequestBody
            CreateProjectReqDto reqDto,
            Principal principal
    ) {
        User user = userService.getUserByUsername(principal.getName());

        ProjectDto project = projectService
                .createNewProject(user, reqDto.getName(), reqDto.getDescriptions());

        return new ResponseEntity<ProjectDto>(project, HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity deleteProject(
            @RequestBody Long projectId,
            Principal principal
    ) {
        User user = userService.getUserByUsername(principal.getName());
        projectService.deleteProject(user, projectId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/{projectId}/employee")
    public ResponseEntity addEmployeeInProject(
            @PathVariable Long projectId,
            @RequestBody Long employeeUserId,
            Principal principal
    ) {
        User user = userService.getUserByUsername(principal.getName());
        projectService.addEmployeeInProject(user, projectId, employeeUserId);
        return null;
    }

    @DeleteMapping("/{projectId}/employee")
    public ResponseEntity deleteEmployeeInProject(
            @PathVariable Long projectId,
            @RequestBody Long employeeUserId,
            Principal principal
    ) {
        User user = userService.getUserByUsername(principal.getName());
        projectService.deleteEmployeeInProject(user, projectId, employeeUserId);
        return null;
    }
}
