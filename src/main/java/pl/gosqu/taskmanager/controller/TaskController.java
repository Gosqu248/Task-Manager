package pl.gosqu.taskmanager.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.gosqu.taskmanager.request.TaskRequest;
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

    @PostMapping
    public ResponseEntity<String> createTask(
            @RequestBody TaskRequest taskRequest
    ) {
        return ResponseEntity.ok(service.createTask(taskRequest));
    }

    @PutMapping("/{task-id}")
    public ResponseEntity<String> updateTask(
            @PathVariable("task-id") Long taskId,
            @RequestBody TaskRequest taskRequest
    ) {
        return ResponseEntity.ok(service.updateTask(taskId, taskRequest));
    }

    @DeleteMapping("/{task-id}")
    public ResponseEntity<Void> deleteTask(
            @PathVariable("task-id") Long taskId
    ) {
        service.deleteTask(taskId);
        return ResponseEntity.noContent().build();
    }
}
