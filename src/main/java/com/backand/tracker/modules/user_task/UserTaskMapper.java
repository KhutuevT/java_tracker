package com.backand.tracker.modules.user_task;

import com.backand.tracker.modules.project.Project;
import com.backand.tracker.modules.project.dto.res.ProjectDto;
import com.backand.tracker.modules.user_task.dto.res.UserTaskDto;
import com.backand.tracker.utils.AbstractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserTaskMapper extends AbstractMapper<UserTask, UserTaskDto> {

    @Autowired
    public UserTaskMapper() {
        super(UserTask.class, UserTaskDto.class);
    }
}
