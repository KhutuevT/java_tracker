package com.backand.tracker.modules.project.service;

import com.backand.tracker.modules.project.Project;
import com.backand.tracker.modules.project.ProjectMapper;
import com.backand.tracker.modules.project.ProjectRepository;
import com.backand.tracker.modules.project.dto.res.ProjectDto;
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

    private final ProjectMapper projectMapper;


    @Autowired
    public ProjectServiceImpl(
            ProjectRepository projectRepository,
            UserProjectService userProjectService,
            UserService userService,
            ProjectMapper projectMapper
    ) {
        this.projectRepository = projectRepository;
        this.userProjectService = userProjectService;
        this.userService = userService;
        this.projectMapper = projectMapper;
    }

    @Override
    public ProjectDto createNewProject(
            User user,
            String name,
            String descriptions
    ) {
        Project project = projectRepository
                .save(new Project(name, descriptions, user));

        return projectMapper.toDto(project);
    }

    @Override
    public ProjectDto getById(
            User user,
            Long id
    ) {
        Project project = getById(id);
        UserPermissionsCheck
                .checkUserPermissionInProjectWithException(
                        user,
                        project,
                        ProjectPermissionsEnum.READ
                );

        return projectMapper.toDto(project);
    }

    @Override
    public void deleteProject(
            User user,
            Long projectId,
            Long projectOwnerUserId
    ) {
        Project project = getById(projectId);
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

        Project project = getById(projectId);
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
        User employee = userService.getUser(employeeUserId);

        Project project = getById(projectId);

        UserPermissionsCheck
                .checkUserPermissionInProjectWithException(
                        user,
                        project,
                        ProjectPermissionsEnum.DELETE_USER
                );

        userProjectService
                .deleteUserProject(employee, project);
    }

    public Project getById(Long projectId) {
        return projectRepository
                .getProjectById(projectId).orElseThrow(
                        () -> new EntityNotFoundException(
                                "Project not found!"));
    }
}
