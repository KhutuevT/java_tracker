package com.backand.tracker.modules.user_project.services;

import com.backand.tracker.modules.project.Project;
import com.backand.tracker.modules.user_project.UserProject;
import com.backand.tracker.modules.user.User;

public interface UserProjectService {
    UserProject createNewUserProject(User user, Project project);

    UserProject deleteUserProject(User user, Project project);
}
