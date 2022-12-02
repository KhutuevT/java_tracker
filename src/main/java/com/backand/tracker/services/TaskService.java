package com.backand.tracker.services;

import com.backand.tracker.domains.task.Task;
import com.backand.tracker.domains.user.User;

import java.util.List;

public interface TaskService {
    List<Task> getAllTaskByProjectId(User user, Long projectId);

    Task getTaskById(User user, Long projectId, Long taskId);

    Task createNewTask(User user, String name, String description, Long projectId);

    void deleteTask(User user, Long taskOwnerUserId, Long taskId);

    void addTaskExecutor(User user, Long taskId, Long taskExecutorUserId, Long taskOwnerUserId);

    void deleteTaskExecutor(User user, Long taskId, Long taskExecutorUserId, Long taskOwnerUserId);

    void deleteTaskExecutor(User user, Long taskId, Long taskExecutorUserId);
}
