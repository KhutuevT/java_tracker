package com.backand.tracker.services.impl;

import com.backand.tracker.domains.project.Project;
import com.backand.tracker.domains.task.Task;
import com.backand.tracker.domains.user.User;
import com.backand.tracker.repositories.ProjectRepository;
import com.backand.tracker.repositories.TaskRepository;
import com.backand.tracker.services.ProjectService;
import com.backand.tracker.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ProjectService projectService;

    @Autowired
    public TaskServiceImpl(
            TaskRepository taskRepository,
            ProjectService projectService
    ) {
        this.taskRepository = taskRepository;
        this.projectService = projectService;
    }

    @Override
    public List<Task> getAllTaskByProjectId(User user, Long projectId) {
        return (List<Task>) taskRepository.getTaskByProjectId(projectId);
    }

    @Override
    public Task getTaskById(User user, Long projectId, Long taskId) {
        return taskRepository.getTaskByIdAndProjectId(taskId, projectId).get(); //TODO
    }

    @Override
    public Task createNewTask(User user, String name, String description, Long projectId) {
        Project project = projectService.getById(user, projectId);
        Task task = new Task(name, description, project, user);
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(User user, Long taskOwnerUserId, Long taskId) {

    }

    @Override
    public void addTaskExecutor(User user, Long taskId, Long taskExecutorUserId, Long taskOwnerUserId) {

    }

    @Override
    public void deleteTaskExecutor(User user, Long taskId, Long taskExecutorUserId, Long taskOwnerUserId) {

    }

    @Override
    public void deleteTaskExecutor(User user, Long taskId, Long taskExecutorUserId) {

    }
}
