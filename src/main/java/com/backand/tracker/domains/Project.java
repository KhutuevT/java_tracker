package com.backand.tracker.domains;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User owner;

    @OneToMany(fetch = FetchType.LAZY)
    List<Task> tasks;

    @OneToMany(fetch = FetchType.LAZY)
    List<User> users;
}
