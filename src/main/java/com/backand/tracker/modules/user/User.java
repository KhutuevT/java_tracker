package com.backand.tracker.modules.user;

import com.backand.tracker.utils.AbstractBaseEntity;
import com.backand.tracker.modules.project_role.ProjectRole;
import com.backand.tracker.modules.user.primitives.EmailAddress;
import com.backand.tracker.modules.user.primitives.Password;
import com.backand.tracker.modules.user_project.UserProject;
import com.backand.tracker.modules.task_role.TaskRole;
import com.backand.tracker.modules.time_slice.TimeSlice;
import com.backand.tracker.modules.user_task.UserTask;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "users")
@Setter
@Getter
public class User extends AbstractBaseEntity {
    @Column(name = "username")
    String username;

    @Embedded
    @AttributeOverride(name = "emailAddress", column = @Column(name = "email"))
    private EmailAddress emailAddress;

    @Embedded
    @AttributeOverride(name = "password", column = @Column(name = "password"))
    private Password password;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY)
    private Collection<ProjectRole> createdProjectRoles;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY)
    private Collection<TaskRole> createdTaskRoles;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY)
    private Collection<UserTask> userTasks;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY)
    private Collection<UserProject> userProjects;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY)
    private Collection<TimeSlice> timeSlices;

    @Deprecated
    public User() {
    }

    public User(String name, EmailAddress emailAddress, Password password) {
        this.username = name;
        this.emailAddress = emailAddress;
        this.password = password;
    }
}
