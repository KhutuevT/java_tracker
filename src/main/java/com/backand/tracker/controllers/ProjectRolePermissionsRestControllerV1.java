package com.backand.tracker.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/projects/{projectId}/roles/{roleId}/permissions")
public class ProjectRolePermissionsRestControllerV1 {
    @GetMapping()
    public ResponseEntity getProjectRolesPermissions(
            @PathVariable Long projectId,
            @PathVariable Long roleId
    ) {
        return null;
    }

    @GetMapping("/{permissionsId}")
    public ResponseEntity getProjectRolesPermissionsById(
            @PathVariable Long projectId,
            @PathVariable Long roleId,
            @PathVariable Long permissionsId
    ) {
        return null;
    }
}
