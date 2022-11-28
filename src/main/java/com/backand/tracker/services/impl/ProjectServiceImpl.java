package com.backand.tracker.services.impl;

import com.backand.tracker.domains.Project;
import com.backand.tracker.services.ProjectService;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {
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
}
