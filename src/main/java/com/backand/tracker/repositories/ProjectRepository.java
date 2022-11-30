package com.backand.tracker.repositories;

import com.backand.tracker.domains.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectRepository  extends JpaRepository<Project, Long> {
    Optional<Project> getProjectById(Long id);

}
