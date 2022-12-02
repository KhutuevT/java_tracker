package com.backand.tracker.repositories;

import com.backand.tracker.domains.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Collection<Task> getTaskByProjectId(Long projectId);

    Optional<Task> getTaskByIdAndProjectId(Long id, Long projectId);
}
