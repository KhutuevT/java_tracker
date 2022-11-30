package com.backand.tracker.repositories;

import com.backand.tracker.domains.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository  extends JpaRepository<Project, Long> {
}
