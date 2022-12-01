package com.backand.tracker.repositories;

import com.backand.tracker.domains.project.ProjectRolePermissions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRolePermissionsRepository extends JpaRepository<ProjectRolePermissions, Long> {
}
