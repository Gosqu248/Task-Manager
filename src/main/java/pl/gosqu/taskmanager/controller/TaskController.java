package pl.gosqu.taskmanager.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.gosqu.taskmanager.response.TaskResponse;
import pl.gosqu.taskmanager.service.TaskService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/task")
public class TaskController {
    private final TaskService service;

    @GetMapping
    public ResponseEntity<List<TaskResponse>> getAllTasks() {
        return ResponseEntity.ok(service.getAllTasks());
    }

    @GetMapping("/{task-id}")
    public ResponseEntity<TaskResponse> getTask(
            @PathVariable("task-id") Long taskId
    ) {
        return ResponseEntity.ok(service.getTaskById(taskId));
    }
}
