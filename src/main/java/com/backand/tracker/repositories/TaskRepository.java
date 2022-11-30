package com.backand.tracker.repositories;

import com.backand.tracker.domains.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
