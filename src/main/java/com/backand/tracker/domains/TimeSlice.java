package com.backand.tracker.domains;

import com.backand.tracker.domains.primitives.EmailAddress;
import com.backand.tracker.domains.primitives.TimePoint;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "time_slice")
@Data
public class TimeSlice extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Embedded
    @AttributeOverride(name = "timePoint", column = @Column(name = "start_time_point"))
    private TimePoint startTimePoint;

    @Embedded
    @AttributeOverride(name = "timePoint", column = @Column(name = "end_time_point"))
    private TimePoint endTimePoint;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
