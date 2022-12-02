package com.backand.tracker.controllers;

import com.backand.tracker.domains.user.User;
import com.backand.tracker.repositories.UserRepository;
import com.backand.tracker.services.TimeSliceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping(value = "/api/v1/projects/{projectId}/tasks/{taskId}/time-slice")
public class TimeSliceRestControllerV1 {

    private TimeSliceService timeSliceService;
    private UserRepository userRepository;

    @Autowired
    public TimeSliceRestControllerV1(
            TimeSliceService timeSliceService,
            UserRepository userRepository
    ) {
        this.timeSliceService = timeSliceService;
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseEntity getAll(
            @PathVariable Long projectId,
            @PathVariable Long taskId,
            Principal principal
    ) {
        User user = userRepository.findByUsername(principal.getName()).get();
        return null;
    }

    @GetMapping("/{timeSliceId}")
    public ResponseEntity getById(
            @PathVariable Long projectId,
            @PathVariable Long taskId,
            @PathVariable Long timeSliceId,
            Principal principal
    ) {
        User user = userRepository.findByUsername(principal.getName()).get();
        return null;
    }

    @PostMapping("/{timeSliceId}/start")
    ResponseEntity start(
            @PathVariable Long projectId,
            @PathVariable Long taskId,
            Principal principal
    ){
        User user = userRepository.findByUsername(principal.getName()).get();
        return null;
    }

    @PostMapping("/{timeSliceId}/stop")
    ResponseEntity stop(
            @PathVariable Long projectId,
            @PathVariable Long taskId,
            Principal principal
    ){
        User user = userRepository.findByUsername(principal.getName()).get();
        return null;
    }
}
