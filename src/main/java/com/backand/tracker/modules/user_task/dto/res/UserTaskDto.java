package com.backand.tracker.modules.user_task.dto.res;

import com.backand.tracker.modules.task.dto.res.TaskDto;
import com.backand.tracker.modules.task_role.dto.res.TaskRoleDto;
import com.backand.tracker.modules.user.dto.res.UserDto;
import com.backand.tracker.utils.AbstractDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserTaskDto extends AbstractDto {
    private UserDto user;
    private TaskDto task;
    private TaskRoleDto role;
}
