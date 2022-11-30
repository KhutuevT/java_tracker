package com.backand.tracker.repositories;

import com.backand.tracker.domains.task.TimeSlice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeSliceRepository extends JpaRepository<TimeSlice, Long> {
}
