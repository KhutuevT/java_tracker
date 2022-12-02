package com.backand.tracker.controllers;

import com.backand.tracker.domains.user.User;
import com.backand.tracker.repositories.UserRepository;
import com.backand.tracker.services.ProjectRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

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
        return null;
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
            @PathVariable String projectId,
            Principal principal
    ) {
        User user = userRepository.findByUsername(principal.getName()).get();
        return null;
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
