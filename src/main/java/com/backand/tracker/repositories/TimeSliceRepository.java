package com.backand.tracker.repositories;

import com.backand.tracker.domains.TimeSlice;
import com.backand.tracker.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimeSliceRepository extends JpaRepository<TimeSlice, Long> {
}
