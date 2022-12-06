package com.backand.tracker.services.impl;

import com.backand.tracker.domains.project.Project;
import com.backand.tracker.domains.project.ProjectRole;
import com.backand.tracker.domains.project.UserProject;
import com.backand.tracker.domains.user.User;
import com.backand.tracker.repositories.UserProjectRepository;
import com.backand.tracker.services.UserProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProjectServiceImpl implements UserProjectService {

    private final UserProjectRepository userProjectRepository;

    @Autowired
    public UserProjectServiceImpl(UserProjectRepository userProjectRepository) {
        this.userProjectRepository = userProjectRepository;
    }

    @Override
    public UserProject createNewUserProject(User user, Project project) {
        return null;
    }
}
