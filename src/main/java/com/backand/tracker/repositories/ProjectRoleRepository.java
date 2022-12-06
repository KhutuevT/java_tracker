package com.backand.tracker.repositories;

import com.backand.tracker.domains.project.ProjectRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ProjectRoleRepository extends JpaRepository<ProjectRole, Long> {
    Collection<ProjectRole> getByProjectId(Long projectId);

    Collection<ProjectRole> findProjectRolesByProjectId(Long projectId);
}
