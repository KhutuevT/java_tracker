package com.backand.tracker.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/projects/{projectId}/roles")
public class ProjectRoleRestControllerV1 {

    @GetMapping()
    public ResponseEntity get(@PathVariable Long projectId) {
        return null;
    }

    @GetMapping("/{roleId}")
    public ResponseEntity getById(
            @PathVariable Long projectId,
            @PathVariable Long roleId
    ) {
        return null;
    }

    @PostMapping()
    public ResponseEntity addNew(@PathVariable String projectId) {
        return null;
    }

    @DeleteMapping("/{roleId}")
    public ResponseEntity deleteById(
            @PathVariable Long projectId,
            @PathVariable Long roleId
    ) {
        return null;
    }
}
