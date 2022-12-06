package com.backand.tracker.services.impl;

import com.backand.tracker.domains.project.Project;
import com.backand.tracker.domains.project.UserProject;
import com.backand.tracker.domains.user.User;
import com.backand.tracker.repositories.ProjectRepository;
import com.backand.tracker.services.ProjectService;
import com.backand.tracker.services.UserProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final UserProjectService userProjectService;

    @Autowired
    public ProjectServiceImpl(
            ProjectRepository projectRepository,
            UserProjectService userProjectService) {
        this.projectRepository = projectRepository;
        this.userProjectService = userProjectService;
    }

    @Override
    public Project createNewProject(User user, String name, String descriptions) {
        Project project = projectRepository.save(new Project(name, descriptions, user));
        return project;
    }

    @Override
    public Project getById(User user, Long id) {
        Project project = projectRepository.getProjectById(id).orElseThrow(()->new EntityNotFoundException("Project not found!"));
        //TODO проверить доступен ли просмотр этому юзеру
        return project;
    }

    @Override
    public void deleteProject(User user, Long projectId, Long projectOwnerUserId) {

    }

    @Override
    public void addEmployeeInProject(User user, Long projectId, Long projectOwnerId, Long employeeUserId) {

    }

    @Override
    public void deleteEmployeeInProject(User user, Long projectId, Long projectOwnerId, Long employeeUserId) {

    }
}
