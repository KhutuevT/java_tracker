package com.backand.tracker.repositories;

import com.backand.tracker.domains.project.UserProject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProjectRepository extends JpaRepository<UserProject, Long> {
}
