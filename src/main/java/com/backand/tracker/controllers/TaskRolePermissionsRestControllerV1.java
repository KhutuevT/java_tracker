package com.backand.tracker.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/projects/tasks/{taskId}/roles/{roleId}/permissions")
public class TaskRolePermissionsRestControllerV1 {

    @GetMapping()
    public ResponseEntity getTaskRolesPermissions(
            @PathVariable Long taskId,
            @PathVariable Long roleId
    ) {
       return null;
    }

    @GetMapping("/{permissionsId}")
    public ResponseEntity getTaskRolesPermissionsById(
            @PathVariable Long taskId,
            @PathVariable Long roleId,
            @PathVariable Long permissionsId
    ) {
        return null;
    }

}
