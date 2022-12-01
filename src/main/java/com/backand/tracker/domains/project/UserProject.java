package com.backand.tracker.domains.project;

import com.backand.tracker.domains.BaseEntity;
import com.backand.tracker.domains.user.User;
import lombok.Data;

import javax.persistence.*;

/**
 * Описывает проекты юзера
 * (созданные им или если его добавили в проект)
 */
@Data
@Table(name = "user_projects")
@Entity
public class UserProject extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_role_id")
    private ProjectRole role;

    @Deprecated
    public UserProject(){
    }

    public UserProject(
            User user,
            Project project,
            ProjectRole role
    ) {
        this.user = user;
        this.project = project;
        this.role = role;
    }
}
