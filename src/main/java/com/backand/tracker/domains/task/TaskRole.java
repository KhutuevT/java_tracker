package com.backand.tracker.domains.task;

import com.backand.tracker.domains.BaseEntity;
import com.backand.tracker.domains.user.User;
import liquibase.pro.packaged.F;
import liquibase.pro.packaged.O;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

/**
 * Описывает роли которые могут быть у пользователей в таске
 */
@Data
@Table(name = "task_roles")
@Entity
public class TaskRole extends BaseEntity {
    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User creator;

//    @ElementCollection(targetClass = TaskPermissionsEnum.class)
//    @Enumerated(EnumType.STRING)
//    @CollectionTable(name = "task_role_permissions")
//    @Column(name = "permissions")
//    private Collection<TaskPermissionsEnum> permissions;

    @OneToMany(fetch = FetchType.LAZY)
    private Collection<TaskRolePermissions> taskRolePermissions;

    @OneToMany(fetch = FetchType.LAZY)
    private Collection<UserTask> userTasks;

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
   }

}
