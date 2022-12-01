package com.backand.tracker.repositories;

import com.backand.tracker.domains.task.UserTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTaskRepository extends JpaRepository<UserTask, Long> {
}
