package com.backand.tracker.services;

import com.backand.tracker.domains.project.Project;
import com.backand.tracker.domains.project.ProjectRole;
import com.backand.tracker.domains.project.UserProject;
import com.backand.tracker.domains.user.User;

public interface UserProjectService {
    UserProject createNewUserProject(User user, Project project);

}
