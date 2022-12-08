package com.backand.tracker.modules.project_role_permission;

import com.backand.tracker.modules.project_role.ProjectRole;
import com.backand.tracker.utils.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "project_role_permissions")
public class ProjectRolePermissions extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_role_id")
    private ProjectRole projectRole;

    @Enumerated(EnumType.STRING)
    @Column(name = "permission")
    private ProjectPermissionsEnum projectPermission;
}
