package com.backand.tracker.controllers;

import com.backand.tracker.services.TimeSliceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class TimeSliceRestControllerV1 {

    TimeSliceService timeSliceService;

    @Autowired
    public TimeSliceRestControllerV1(TimeSliceService timeSliceService) {
        this.timeSliceService = timeSliceService;
    }

    @GetMapping
    public ResponseEntity getAll() {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        return null;
    }
}
