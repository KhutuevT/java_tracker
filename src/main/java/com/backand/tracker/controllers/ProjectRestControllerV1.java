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

    @GetMapping("/test")
    public ResponseEntity test(){
        return new ResponseEntity("Test", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        return null;
    }


}
