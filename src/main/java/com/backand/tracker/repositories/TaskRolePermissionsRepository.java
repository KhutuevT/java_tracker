package com.backand.tracker.repositories;

import com.backand.tracker.domains.task.TaskRolePermissions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRolePermissionsRepository extends JpaRepository<TaskRolePermissions, Long> {
}
