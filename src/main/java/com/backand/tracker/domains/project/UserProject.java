package com.backand.tracker.domains.project;

import com.backand.tracker.domains.BaseEntity;
import com.backand.tracker.domains.user.User;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "user_project_roles")
@Entity
public class UserProject extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_project_roles_id")
    private UserProject role;

    @Deprecated
    public UserProject(){
    }

    public UserProject(
            User user,
            Project project,
            UserProject role
    ) {
        this.user = user;
        this.project = project;
        this.role = role;
    }
}
