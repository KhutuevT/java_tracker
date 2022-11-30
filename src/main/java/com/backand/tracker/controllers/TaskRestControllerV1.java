package com.backand.tracker.controllers;

import com.backand.tracker.dtos.req.AddTaskReqDto;
import com.backand.tracker.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/tasks")
public class TaskRestControllerV1 {

    TaskService taskService;

    @Autowired
    public TaskRestControllerV1(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping()
    ResponseEntity get(){
        return null;
    }

    @PostMapping()
    ResponseEntity add(@RequestBody AddTaskReqDto reqDto) {
        Long userId = 1L;
        taskService.createNewTask(reqDto.getName(), reqDto.getDescriptions(), userId);
        return new ResponseEntity("OK", HttpStatus.OK);
    }

    @PostMapping("/start/{id}")
    ResponseEntity start(@PathVariable("id") Long taskId){
        Long userId = 1L;
        taskService.start(taskId, userId);
        return new ResponseEntity("OK", HttpStatus.OK);
    }

    @PostMapping("/stop/{id}")
    ResponseEntity stop(@PathVariable("id") Long taskId){
        Long userId = 1L;
        taskService.stop(taskId, userId);
        return new ResponseEntity("OK", HttpStatus.OK);
    }
}
