package com.backand.tracker.services;

import com.backand.tracker.domains.primitives.TimePoint;
import com.backand.tracker.domains.task.Task;
import com.backand.tracker.domains.task.TimeSlice;
import com.backand.tracker.domains.user.User;

import java.util.List;

public interface TimeSliceService {
    TimeSlice getById(Long id);

    List<TimeSlice> getTaskTimeSlices(Long taskId);

    List<TimeSlice> getTaskTimeSlices(Long taskId, TimePoint startDate, TimePoint endDate);

    List<TimeSlice> getTaskTimeSlicesByUser(Long taskId, Long userId);

    List<TimeSlice> getTaskTimeSlicesByUser(Long taskId, Long userId, TimePoint startDate, TimePoint endDate);

    TimeSlice start(User user, Long projectId, Long taskId, String name);
    TimeSlice stop(User user, Long projectId, Long taskId);
}
