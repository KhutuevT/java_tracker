package com.backand.tracker.repositories;

import com.backand.tracker.domains.task.TaskRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRoleRepository extends JpaRepository<TaskRole, Long> {
}
