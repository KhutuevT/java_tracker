package com.backand.tracker.modules.task_role.dto.res;

import com.backand.tracker.modules.task.dto.res.TaskDto;
import com.backand.tracker.modules.task_role_permission.dto.res.TaskRolePermissionsDto;
import com.backand.tracker.modules.user.dto.res.UserDto;
import com.backand.tracker.modules.user_task.dto.res.UserTaskDto;
import com.backand.tracker.utils.AbstractDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Collection;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskRoleDto extends AbstractDto {
    private String name;
    private UserDto creator;
    private TaskDto task;
    private Collection<TaskRolePermissionsDto> taskRolePermissions;
    private Collection<UserTaskDto> userTasks;
}
