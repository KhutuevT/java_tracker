package com.backand.tracker.services.impl;

import com.backand.tracker.domains.project.Project;
import com.backand.tracker.domains.project.ProjectRole;
import com.backand.tracker.domains.user.User;
import com.backand.tracker.repositories.ProjectRoleRepository;
import com.backand.tracker.services.ProjectRoleService;
import com.backand.tracker.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProjectRoleServiceImpl implements ProjectRoleService {

    private ProjectRoleRepository projectRoleRepository;
    private ProjectService projectService;

    @Autowired
    public ProjectRoleServiceImpl(
            ProjectRoleRepository projectRoleRepository,
            ProjectService projectService
    ) {
        this.projectRoleRepository = projectRoleRepository;
        this.projectService = projectService;
    }

    @Override
    public ProjectRole createNew(String name, User creator, Long projectId) {
        Project project = projectService.getById(creator, projectId);
        ProjectRole projectRole = new ProjectRole(name, creator, project);
        return projectRoleRepository.save(projectRole);
    }

    @Override
    public Collection<ProjectRole> getAllByProject(User user, Long projectId) {
        //TODO проверить доступ
        //return projectRoleRepository.getByProjectId(projectId);
        return projectRoleRepository.findProjectRolesByProjectId(projectId);
    }

    @Override
    public ProjectRole getById(User user, Long id) {
        return null;
    }
}
