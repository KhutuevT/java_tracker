package com.backand.tracker.domains.project;

import com.backand.tracker.domains.BaseEntity;
import com.backand.tracker.domains.task.Task;
import com.backand.tracker.domains.user.User;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "projects")
@Data
public class Project extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "descriptions")
    private String descriptions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User creator;

    @OneToMany(fetch = FetchType.LAZY)
    private Collection<Task> tasks;

    @OneToMany(fetch = FetchType.LAZY)
    private Collection<UserProject> userProjects;

    @OneToMany(fetch = FetchType.LAZY)
    private Collection<ProjectRole> projectRoles;

    @Deprecated
    public Project(){
    }

    public Project(
            String name,
            String descriptions
    ) {
        this.name = name;
        this.descriptions = descriptions;
    }
}
