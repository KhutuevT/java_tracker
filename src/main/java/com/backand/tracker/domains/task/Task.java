package com.backand.tracker.domains.task;

import com.backand.tracker.domains.BaseEntity;
import com.backand.tracker.domains.project.Project;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tasks")
@Data
public class Task extends BaseEntity {
    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;

    @OneToMany(fetch = FetchType.LAZY)
    List<TimeSlice> timeSlices;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @Deprecated
    public Task(){
    }

    public Task(
            String name,
            String description,
            Project project
    ) {
        this.name = name;
        this.description = description;
        this.project = project;
    }
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User creator;
}
