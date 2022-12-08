package com.backand.tracker.services;

import com.backand.tracker.domains.project.Project;
import com.backand.tracker.domains.project.ProjectRole;
import com.backand.tracker.domains.user.User;

import java.util.Collection;

public interface ProjectRoleService {
    ProjectRole createNew(String name, User creator, Long projectId);

    void delete(User user, Long id, Long projectId);

    Collection<ProjectRole> getAllByProject(User user, Long projectId);

    ProjectRole getById(User user, Long id, Long projectId);
}
