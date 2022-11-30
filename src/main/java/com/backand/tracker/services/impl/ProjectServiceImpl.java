package com.backand.tracker.services.impl;

import com.backand.tracker.domains.project.Project;
import com.backand.tracker.repositories.ProjectRepository;
import com.backand.tracker.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project createNewProject(String name, String descriptions, Long projectOwnerUserId) {
        return null;
    }

    @Override
    public void deleteProject(Long projectId, Long projectOwnerUserId) {

    }

    @Override
    public void addEmployeeInProject(Long projectId, Long projectOwnerId, Long employeeUserId) {

    }

    @Override
    public void deleteEmployeeInProject(Long projectId, Long projectOwnerId, Long employeeUserId) {

    }

    @Override
    public Project getById(Long id) {
        try {
            Project project = projectRepository.getProjectById(id).get();
            return project;
        } catch (Exception e) {
            System.out.println("-----------------");
            System.out.println(e);
        }
        return null;
    }
}
