package com.backand.tracker.domains.user;

import com.backand.tracker.domains.BaseEntity;
import com.backand.tracker.domains.project.Project;
import com.backand.tracker.domains.project.ProjectRole;
import com.backand.tracker.domains.primitives.EmailAddress;
import com.backand.tracker.domains.primitives.Password;
import com.backand.tracker.domains.project.UserProject;
import com.backand.tracker.domains.task.TaskRole;
import com.backand.tracker.domains.task.TimeSlice;
import com.backand.tracker.domains.task.UserTask;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User extends BaseEntity {
    @Column(name = "username")
    String username;

    @Embedded
    @AttributeOverride(name = "emailAddress", column = @Column(name = "email"))
    private EmailAddress emailAddress;

    @Embedded
    @AttributeOverride(name = "password", column = @Column(name = "password"))
    private Password password;

    @OneToMany(fetch = FetchType.LAZY)
    private Collection<ProjectRole> createdProjectRoles;

    @OneToMany(fetch = FetchType.LAZY)
    private Collection<TaskRole> createdTaskRoles;

    @OneToMany(fetch = FetchType.LAZY)
    private Collection<UserTask> userTasks;

    @OneToMany(fetch = FetchType.LAZY)
    private Collection<UserProject> userProjects;

    @OneToMany(fetch = FetchType.LAZY)
    private Collection<TimeSlice> timeSlices;

    @Deprecated
    public User() {}

    public User(String name, EmailAddress emailAddress, Password password) {
        this.username = name;
        this.emailAddress = emailAddress;
        this.password = password;
    }
}
