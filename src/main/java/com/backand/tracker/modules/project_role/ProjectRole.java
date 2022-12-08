package com.backand.tracker.modules.project_role;

import com.backand.tracker.modules.project.Project;
import com.backand.tracker.modules.project_role_permission.ProjectRolePermissions;
import com.backand.tracker.modules.user_project.UserProject;
import com.backand.tracker.utils.BaseEntity;
import com.backand.tracker.modules.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY)
    private Collection<ProjectRolePermissions> projectRolePermissions;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY)
    private Collection<UserProject> userProjects;

    @Deprecated
    public ProjectRole(){
    }

    public ProjectRole(
            String name,
            User creator,
            Project project
    ) {
        this.name = name;
        this.creator = creator;
        this.project = project;
    }
}
