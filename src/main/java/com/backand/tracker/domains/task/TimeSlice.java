package com.backand.tracker.domains.task;

import com.backand.tracker.domains.BaseEntity;
import com.backand.tracker.domains.user.User;
import com.backand.tracker.domains.primitives.TimePoint;
import lombok.Data;

import javax.persistence.*;

/**
 * Описывает "затреканный" промежуток времени
 * определённым юзером в определённой таске.
 */
@Entity
@Table(name = "time_slice")
@Data
public class TimeSlice extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Embedded
    @AttributeOverride(name = "timePoint", column = @Column(name = "start_time_point"))
    @Temporal(TemporalType.TIMESTAMP)
    private TimePoint startTimePoint;

    @Embedded
    @AttributeOverride(name = "timePoint", column = @Column(name = "end_time_point"))
    @Temporal(TemporalType.TIMESTAMP)
    private TimePoint endTimePoint;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private Task task;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Deprecated
    public TimeSlice(){
    }

    public TimeSlice(
            String name,
            TimePoint startTimePoint,
            //TimePoint endTimePoint,
            Task task,
            User user
    ) {
        this.name = name;
        this.startTimePoint = startTimePoint;
        //this.endTimePoint = endTimePoint;
        this.task = task;
        this.user = user;
    }
}
