package com.backand.tracker.controllers;

import com.backand.tracker.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/projects")
public class ProjectRestControllerV1 {

    ProjectService projectService;

    @Autowired
    ProjectRestControllerV1(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        return new ResponseEntity(projectService.getById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity createNewProject() {
        return null;
    }

    @PostMapping("/employee")
    public ResponseEntity addEmployeeInProject() {
        return null;
    }

    @DeleteMapping("/employee")
    public ResponseEntity deleteEmployeeInProject() {
        return null;
    }

    @PostMapping("/permission-in-role")
    public ResponseEntity addPermissionsInRole() {
        return null;
    }

    @DeleteMapping("/permission-in-role")
    public ResponseEntity deletePermissionsInRole() {
        return null;
    }
}
