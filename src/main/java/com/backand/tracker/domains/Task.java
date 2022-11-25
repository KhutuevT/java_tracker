package com.backand.tracker.domains;

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
    @JoinColumn(name = "user_id")
    private User creator;
}
