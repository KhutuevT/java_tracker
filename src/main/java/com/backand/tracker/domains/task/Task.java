package com.backand.tracker.domains.task;

import com.backand.tracker.domains.BaseEntity;
import com.backand.tracker.domains.project.Project;
import com.backand.tracker.domains.user.User;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "tasks")
@Data
public class Task extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User creator;

    @OneToMany(fetch = FetchType.LAZY)
    private List<TimeSlice> timeSlices;

    @OneToMany(fetch = FetchType.LAZY)
    private Collection<UserTask> userTasks;

    @OneToMany(fetch = FetchType.LAZY)
    private Collection<TaskRole> taskRoles;

    @Deprecated
    public Task(){
    }

    public Task(
            String name,
            String description,
            Project project,
            User creator
    ) {
        this.name = name;
        this.description = description;
        this.project = project;
        this.creator = creator;
    }
}
