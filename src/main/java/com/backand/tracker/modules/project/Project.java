package com.backand.tracker.modules.project;

import com.backand.tracker.modules.project_role.ProjectRole;
import com.backand.tracker.modules.user_project.UserProject;
import com.backand.tracker.utils.AbstractBaseEntity;
import com.backand.tracker.modules.task.Task;
import com.backand.tracker.modules.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "projects")
@Setter
@Getter
public class Project extends AbstractBaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "descriptions")
    private String descriptions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User creator;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private Collection<Task> tasks;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private Collection<UserProject> userProjects;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private Collection<ProjectRole> projectRoles;

    @Deprecated
    public Project() {
    }

    public Project(
            String name,
            String descriptions,
            User creator
    ) {
        this.name = name;
        this.descriptions = descriptions;
        this.creator = creator;
    }
}
