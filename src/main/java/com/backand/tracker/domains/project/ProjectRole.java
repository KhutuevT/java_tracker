package com.backand.tracker.domains.project;

import com.backand.tracker.domains.BaseEntity;
import com.backand.tracker.domains.user.User;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@Table(name = "project_roles")
public class ProjectRole extends BaseEntity {
    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User creator;

    @ElementCollection(targetClass = ProjectPermissionsEnum.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "project_role_permissions")
    @Column(name = "permissions")
    Collection<ProjectPermissionsEnum> permissions;

    @Deprecated
    public ProjectRole(){
    }

    public ProjectRole(
            String name,
            User creator,
            Collection<ProjectPermissionsEnum> permissions
    ) {
        this.name = name;
        this.creator = creator;
        this.permissions = permissions;
    }
}
