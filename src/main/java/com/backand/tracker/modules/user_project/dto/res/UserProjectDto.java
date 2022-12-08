package com.backand.tracker.modules.user_project.dto.res;

import com.backand.tracker.modules.project.dto.res.ProjectDto;
import com.backand.tracker.modules.project_role.dto.res.ProjectRoleDto;
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
public class UserProjectDto extends AbstractDto {
    private UserDto user;
    private ProjectDto project;
    private ProjectRoleDto role;
}
