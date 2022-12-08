package com.backand.tracker.modules.project.service;

import com.backand.tracker.modules.project.Project;
import com.backand.tracker.modules.project.ProjectRepository;
import com.backand.tracker.modules.user_project.services.UserProjectService;
import com.backand.tracker.modules.project_role_permission.ProjectPermissionsEnum;
import com.backand.tracker.modules.user_project.UserProject;
import com.backand.tracker.modules.user.User;
import com.backand.tracker.modules.user.services.UserService;
import com.backand.tracker.utils.UserPermissionsCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class ProjectServiceImpl implements
        ProjectService {
    private final ProjectRepository projectRepository;
    private final UserProjectService userProjectService;
    private final UserService userService;


    @Autowired
    public ProjectServiceImpl(
            ProjectRepository projectRepository,
            UserProjectService userProjectService,
            UserService userService
    ) {
        this.projectRepository = projectRepository;
        this.userProjectService = userProjectService;
        this.userService = userService;
    }

    @Override
    public Project createNewProject(
            User user,
            String name,
            String descriptions
    ) {
        Project project = projectRepository
                .save(new Project(name, descriptions, user));

        return project;
    }

    @Override
    public Project getById(
            User user,
            Long id
    ) {
        Project project = projectRepository
                .getProjectById(id).orElseThrow(
                        () -> new EntityNotFoundException(
                                "Project not found!"));

        UserPermissionsCheck
                .checkUserPermissionInProjectWithException(
                        user,
                        project,
                        ProjectPermissionsEnum.READ
                );

        return project;
    }

    @Override
    public void deleteProject(
            User user,
            Long projectId,
            Long projectOwnerUserId
    ) {
        Project project = getById(user,
                projectId
        );

        UserPermissionsCheck
                .checkUserPermissionInProjectWithException(
                        user,
                        project,
                        ProjectPermissionsEnum.DELETE
                );

        projectRepository.delete(project);
    }

    @Override
    public void addEmployeeInProject(
            User user,
            Long projectId,
            Long projectOwnerId,
            Long employeeUserId
    ) {
        User employee = userService.getUser(
                employeeUserId);

        Project project = getById(user,
                projectId
        );

        UserPermissionsCheck
                .checkUserPermissionInProjectWithException(
                        user,
                        project,
                        ProjectPermissionsEnum.ADD_USER
                );

        UserProject userProject = userProjectService
                .createNewUserProject(employee, project);
    }

    @Override
    public void deleteEmployeeInProject(
            User user,
            Long projectId,
            Long projectOwnerId,
            Long employeeUserId
    ) {
        User employee = userService.getUser(
                employeeUserId);
        Project project = getById(user,
                projectId
        );

        UserPermissionsCheck
                .checkUserPermissionInProjectWithException(
                        user,
                        project,
                        ProjectPermissionsEnum.DELETE_USER
                );

        userProjectService
                .deleteUserProject(employee, project);
    }
}
