package com.backand.tracker.modules.task.services;

import com.backand.tracker.modules.project.Project;
import com.backand.tracker.modules.project_role_permission.ProjectPermissionsEnum;
import com.backand.tracker.modules.task.Task;
import com.backand.tracker.modules.task_role_permission.TaskPermissionsEnum;
import com.backand.tracker.modules.user.User;
import com.backand.tracker.modules.task.TaskRepository;
import com.backand.tracker.modules.project.service.ProjectService;
import com.backand.tracker.modules.user_project.services.UserProjectService;
import com.backand.tracker.utils.UserPermissionsCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ProjectService projectService;
    private final TaskService taskService;
    private final UserProjectService userProjectService;

    @Autowired
    public TaskServiceImpl(
            TaskRepository taskRepository,
            ProjectService projectService,
            TaskService taskService,
            UserProjectService userProjectService
    ) {
        this.taskRepository = taskRepository;
        this.projectService = projectService;
        this.taskService = taskService;
        this.userProjectService = userProjectService;
    }

    @Override
    public List<Task> getAllTaskByProjectId(User user, Long projectId) {
        Project project = projectService.getById(user, projectId);

        UserPermissionsCheck
                .checkUserPermissionInProjectWithException(
                        user, project, ProjectPermissionsEnum.READ
                );

        return (List<Task>) taskRepository.getTaskByProjectId(projectId);
    }

    @Override
    public Task getTaskById(User user, Long projectId, Long taskId) {
        Project project = projectService.getById(user, projectId);

        UserPermissionsCheck
                .checkUserPermissionInProjectWithException(
                        user, project, ProjectPermissionsEnum.READ
                );
        return taskRepository.getTaskByIdAndProjectId(taskId, projectId)
                .orElseThrow(() -> new EntityNotFoundException("Task not found!"));
    }

    @Override
    public Task createNewTask(User user, String name, String description, Long projectId) {
        Project project = projectService.getById(user, projectId);

        UserPermissionsCheck
                .checkUserPermissionInProjectWithException(
                        user, project, ProjectPermissionsEnum.CREATE_TASK
                );

        Task task = new Task(name, description, project, user);
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(User user, Long taskOwnerUserId, Long taskId, Long projectId) {
        Project project = projectService.getById(user, projectId);

        UserPermissionsCheck
                .checkUserPermissionInProjectWithException(
                        user, project, ProjectPermissionsEnum.DELETE_TASK
                );

        taskRepository.deleteById(taskId);
    }

    @Override
    public void addTaskExecutor(
            User user,
            Long taskId,
            Long projectId,
            Long taskExecutorUserId
    ) {
        Project project = projectService.getById(user, projectId);
        Task task = taskService.getTaskById(user, taskId, projectId);

        UserPermissionsCheck
                .checkUserPermissionInTaskWithException(
                        user, task, TaskPermissionsEnum.ADD_USER
                );

        //UserProject userProject = new UserProject(user, project, baseUserProjectRole);
    }

    @Override
    public void deleteTaskExecutor(
            User user,
            Long taskId,
            Long projectId,
            Long taskExecutorUserId
    ) {
        Project project = projectService.getById(user, projectId);
        Task task = taskService.getTaskById(user, taskId, projectId);

        UserPermissionsCheck
                .checkUserPermissionInTaskWithException(
                        user, task, TaskPermissionsEnum.DELETE_USER
                );

        // UserProject userProject = userProjectService
    }

}
