package com.backand.tracker.domains.task;

import com.backand.tracker.domains.BaseEntity;
import com.backand.tracker.domains.user.User;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "user_task_roles")
@Entity
public class UserTask extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private Task task;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_task_roles_id")
    private UserTask role;

    @Deprecated
    public UserTask(){
    }

    public UserTask(
            User user,
            Task task,
            UserTask role
    ) {
        this.user = user;
        this.task = task;
        this.role = role;
    }
}
