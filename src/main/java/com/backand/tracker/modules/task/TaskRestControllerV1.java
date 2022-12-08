package com.backand.tracker.modules.task;

import com.backand.tracker.modules.task.dto.req.AddTaskReqDto;
import com.backand.tracker.modules.task.services.TaskService;
import com.backand.tracker.modules.user.User;
import com.backand.tracker.modules.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/projects/{projectId}/tasks")
public class TaskRestControllerV1 {

    private TaskService taskService;
    private UserRepository userRepository;

    @Autowired
    public TaskRestControllerV1(
            TaskService taskService,
            UserRepository userRepository
    ) {
        this.taskService = taskService;
        this.userRepository = userRepository;
    }

    @GetMapping()
    ResponseEntity get(
            @PathVariable
            Long projectId,
            Principal principal
    ) {
        User user = userRepository.findByUsername(
                principal.getName()).get();
        List<Task> tasks = taskService.getAllTaskByProjectId(
                user,
                projectId
        );
        return new ResponseEntity(tasks,
                                  HttpStatus.OK
        );
    }

    @GetMapping("/{taskId}")
    ResponseEntity getById(
            @PathVariable
            Long projectId,
            @PathVariable
            Long taskId,
            Principal principal
    ) {
        User user = userRepository.findByUsername(
                principal.getName()).get();
        Task task = taskService.getTaskById(user,
                                            projectId,
                                            taskId
        );
        return new ResponseEntity(task,
                                  HttpStatus.OK
        );
    }

    @PostMapping()
    ResponseEntity add(
            @PathVariable
            Long projectId,
            @RequestBody
            AddTaskReqDto reqDto,
            Principal principal
    ) {
        User user = userRepository.findByUsername(
                principal.getName()).get();
        Task task = taskService
                .createNewTask(
                        user,
                        reqDto.getName(),
                        reqDto.getDescriptions(),
                        projectId
                );

        return new ResponseEntity(task,
                                  HttpStatus.OK
        );
    }
}
