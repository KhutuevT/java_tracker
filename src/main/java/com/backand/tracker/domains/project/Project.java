package com.backand.tracker.domains.project;

import com.backand.tracker.domains.BaseEntity;
import com.backand.tracker.domains.task.Task;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "projects")
@Data
public class Project extends BaseEntity {

    @Column(name = "name")
    String name;

    @Column(name = "descriptions")
    String descriptions;

    @OneToMany(fetch = FetchType.LAZY)
    List<Task> tasks;

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

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User owner;

//    @OneToMany(fetch = FetchType.LAZY)
//    List<User> users;
}
