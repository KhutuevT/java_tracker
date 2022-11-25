package com.backand.tracker.services.impl;

import com.backand.tracker.domains.primitives.TimePoint;
import com.backand.tracker.domains.TimeSlice;
import com.backand.tracker.services.TimeSliceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeSliceServiceImpl implements TimeSliceService {
    @Override
    public TimeSlice getById(Long id) {
        return null;
    }

    @Override
    public List<TimeSlice> getTaskTimeSlices(Long taskId) {
        return null;
    }

    @Override
    public List<TimeSlice> getTaskTimeSlices(Long taskId, TimePoint startDate, TimePoint endDate) {
        return null;
    }

    @Override
    public List<TimeSlice> getTaskTimeSlicesByUser(Long taskId, Long userId) {
        return null;
    }

    @Override
    public List<TimeSlice> getTaskTimeSlicesByUser(Long taskId, Long userId, TimePoint startDate, TimePoint endDate) {
        return null;
    }
}
