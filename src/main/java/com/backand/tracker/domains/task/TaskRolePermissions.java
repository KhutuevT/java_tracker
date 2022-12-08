package com.backand.tracker.domains.task;

import com.backand.tracker.domains.BaseEntity;
import com.backand.tracker.domains.project.ProjectPermissionsEnum;
import com.backand.tracker.domains.project.ProjectRole;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "task_role_permissions")
public class TaskRolePermissions extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_role_id")
    private TaskRole taskRole;

    @Enumerated(EnumType.STRING)
    @Column(name = "permission")
    private TaskPermissionsEnum taskPermissions;
}
