package com.backand.tracker.modules.user_project;

import com.backand.tracker.modules.user_project.dto.res.UserProjectDto;
import com.backand.tracker.utils.AbstractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserProjectMapper extends AbstractMapper<UserProject, UserProjectDto> {

    @Autowired
    public UserProjectMapper() {
        super(UserProject.class, UserProjectDto.class);
    }
}
