package com.backand.tracker.domains.project;

import com.backand.tracker.domains.BaseEntity;
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
