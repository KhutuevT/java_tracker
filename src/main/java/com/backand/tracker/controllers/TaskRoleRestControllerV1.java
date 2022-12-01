package com.backand.tracker.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/projects/tasks/{taskId}/roles")
public class TaskRoleRestControllerV1 {

    @GetMapping()
    public ResponseEntity get(@PathVariable Long taskId) {
        return null;
    }

    @GetMapping("/{roleId}")
    public ResponseEntity getById(
            @PathVariable Long taskId,
            @PathVariable Long roleId
    ) {
        return null;
    }

    @PostMapping()
    public ResponseEntity addNew(@PathVariable String taskId) {
        return null;
    }

    @DeleteMapping("/{roleId}")
    public ResponseEntity deleteById(
            @PathVariable Long taskId,
            @PathVariable Long roleId
    ) {
        return null;
    }
}
