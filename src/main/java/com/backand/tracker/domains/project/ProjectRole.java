package com.backand.tracker.domains.project;

import com.backand.tracker.domains.BaseEntity;
import com.backand.tracker.domains.user.User;
import liquibase.pro.packaged.O;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

/**
 * Описывает роли которые могут быть у пользователей в проекте
 */
@Entity
@Data
@Table(name = "project_roles")
public class ProjectRole extends BaseEntity {
    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User creator;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @OneToMany(fetch = FetchType.LAZY)
    private Collection<ProjectRolePermissions> projectRolePermissions;

    @OneToMany(fetch = FetchType.LAZY)
    private Collection<UserProject> userProjects;

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
    }
}
