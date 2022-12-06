package com.backand.tracker.controllers;

import com.backand.tracker.domains.project.ProjectRole;
import com.backand.tracker.domains.user.User;
import com.backand.tracker.dtos.req.CreateProjectRoleReqDto;
import com.backand.tracker.repositories.UserRepository;
import com.backand.tracker.services.ProjectRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/projects/{projectId}/roles")
public class ProjectRoleRestControllerV1 {

    private ProjectRoleService projectRoleService;
    private UserRepository userRepository;

    @Autowired
    public ProjectRoleRestControllerV1(
        ProjectRoleService projectRoleService,
        UserRepository userRepository
    ) {
        this.userRepository = userRepository;
        this.projectRoleService = projectRoleService;
    }

    @GetMapping()
    public ResponseEntity get(
            @PathVariable Long projectId,
            Principal principal
    ) {
        User user = userRepository.findByUsername(principal.getName()).get();
        Collection<ProjectRole> projectRole = projectRoleService.getAllByProject(user, projectId);
        return new ResponseEntity(projectRole, HttpStatus.OK);
    }

    @GetMapping("/{roleId}")
    public ResponseEntity getById(
            @PathVariable Long projectId,
            @PathVariable Long roleId,
            Principal principal
    ) {
        User user = userRepository.findByUsername(principal.getName()).get();
        return null;
    }

    @PostMapping()
    public ResponseEntity addNew(
            @PathVariable Long projectId,
            @RequestBody CreateProjectRoleReqDto reqDto,
            Principal principal
    ) {
        User user = userRepository.findByUsername(principal.getName()).get();
        ProjectRole projectRole = projectRoleService.createNew(reqDto.getName(), user, projectId);
        return new ResponseEntity(projectRole, HttpStatus.OK);
    }

    @DeleteMapping("/{roleId}")
    public ResponseEntity deleteById(
            @PathVariable Long projectId,
            @PathVariable Long roleId,
            Principal principal
    ) {
        User user = userRepository.findByUsername(principal.getName()).get();
        return null;
    }
}
