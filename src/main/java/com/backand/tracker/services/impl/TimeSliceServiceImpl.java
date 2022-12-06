package com.backand.tracker.services.impl;

import com.backand.tracker.domains.primitives.TimePoint;
import com.backand.tracker.domains.task.Task;
import com.backand.tracker.domains.task.TimeSlice;
import com.backand.tracker.domains.user.User;
import com.backand.tracker.exceptions.TimeSliceAlreadyStartException;
import com.backand.tracker.exceptions.TimeSliceAlreadyStopException;
import com.backand.tracker.repositories.TimeSliceRepository;
import com.backand.tracker.services.TaskService;
import com.backand.tracker.services.TimeSliceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TimeSliceServiceImpl implements TimeSliceService {

    private TimeSliceRepository timeSliceRepository;
    private TaskService taskService;

    @Autowired
    public TimeSliceServiceImpl(
            TimeSliceRepository timeSliceRepository,
            TaskService taskService
    ) {
        this.timeSliceRepository = timeSliceRepository;
        this.taskService = taskService;
    }

    @Override
    public TimeSlice getById(Long id) {
        return timeSliceRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Time slice not found!"));
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

    @Override
    public TimeSlice start(User user, Long projectId, Long taskId, String name) {
        Task task = taskService.getTaskById(user, projectId, taskId);
        TimeSlice lastTimeSlice = getLastTimeSliceByTask(task);

        if(lastTimeSlice != null && lastTimeSlice.getEndTimePoint() == null) {
            throw new TimeSliceAlreadyStartException("Time slice in this task already start!");
        }

        TimePoint timePoint = new TimePoint(new Date());
        TimeSlice timeSlice = new TimeSlice(name, timePoint, task, user);
        return timeSliceRepository.save(timeSlice);
    }

    @Override
    public TimeSlice stop(User user, Long projectId, Long taskId) {
        Task task = taskService.getTaskById(user, projectId, taskId);
        TimeSlice lastTimeSlice = getLastTimeSliceByTask(task);

        if(lastTimeSlice != null && lastTimeSlice.getEndTimePoint() != null) {
            throw new TimeSliceAlreadyStopException("Time slice in this task already stop!");
        }

        TimePoint timePoint = new TimePoint(new Date());
        lastTimeSlice.setEndTimePoint(timePoint);

        return timeSliceRepository.save(lastTimeSlice);
    }

    private TimeSlice getLastTimeSliceByTask(Task task) {
        TimeSlice lastTimeSlice = timeSliceRepository
                .findFirstByTaskOrderByStartTimePointDesc(task)
                .orElse(null);

        return lastTimeSlice;
    }
}
