package com.backand.tracker.domains.task;

import com.backand.tracker.domains.BaseEntity;
import com.backand.tracker.domains.user.User;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Table(name = "task_roles")
@Entity
public class TaskRole extends BaseEntity {
    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User creator;

    @ElementCollection(targetClass = TaskPermissionsEnum.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "task_role_permissions")
    @Column(name = "permissions")
    Collection<TaskPermissionsEnum> permissions;

   @Deprecated
   public TaskRole() {
   }

   public TaskRole(
           String name,
           User creator,
           Collection<TaskPermissionsEnum> permissions
   ) {
       this.name = name;
       this.creator = creator;
       this.permissions = permissions;
   }

}
