package com.backand.tracker.repositories;

import com.backand.tracker.domains.task.Task;
import com.backand.tracker.domains.task.TimeSlice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface TimeSliceRepository extends JpaRepository<TimeSlice, Long> {
    Optional<TimeSlice> findFirstByTaskOrderByStartTimePointDesc(Task task);
    Collection<TimeSlice> findTopByTaskId(Long taskId);
}

