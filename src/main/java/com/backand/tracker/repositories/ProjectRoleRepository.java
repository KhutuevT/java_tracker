package com.backand.tracker.repositories;

import com.backand.tracker.domains.project.ProjectRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRoleRepository extends JpaRepository<ProjectRole, Long> {
}
