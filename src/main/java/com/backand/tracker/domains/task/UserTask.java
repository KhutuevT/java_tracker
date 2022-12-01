package com.backand.tracker.domains.task;

import com.backand.tracker.domains.BaseEntity;
import com.backand.tracker.domains.user.User;
import lombok.Data;

import javax.persistence.*;

/**
 * Описывает таски юзера
 * (созданные им, или если на него повесили таску)
 */
@Data
@Table(name = "user_tasks")
@Entity
public class UserTask extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private Task task;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_role_id")
    private TaskRole role;

    @Deprecated
    public UserTask(){
    }

    public UserTask(
            User user,
            Task task,
            TaskRole role
    ) {
        this.user = user;
        this.task = task;
        this.role = role;
    }
}
