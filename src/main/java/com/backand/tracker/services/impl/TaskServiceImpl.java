package com.backand.tracker.services.impl;

import com.backand.tracker.domains.Task;
import com.backand.tracker.services.TaskService;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
    @Override
    public Task createNewTask(String name, String descriptions, Long taskOwnerUserId) {
        return null;
    }

    @Override
    public void deleteTask(Long taskOwnerUserId, Long taskId) {

    }

    @Override
    public void start(Long taskId, Long taskExecutorUserId) {

    }

    @Override
    public void stop(Long taskId, Long taskExecutorUserId) {

    }

    @Override
    public void addTaskExecutor(Long taskId, Long taskExecutorUserId, Long taskOwnerUserId) {

    }

    @Override
    public void deleteTaskExecutor(Long taskId, Long taskExecutorUserId, Long taskOwnerUserId) {

    }

    @Override
    public void deleteTaskExecutor(Long taskId, Long taskExecutorUserId) {

    }
}
