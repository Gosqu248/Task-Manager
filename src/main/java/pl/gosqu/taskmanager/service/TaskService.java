package pl.gosqu.taskmanager.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import pl.gosqu.taskmanager.repository.TaskRepository;
import pl.gosqu.taskmanager.request.TaskRequest;
import pl.gosqu.taskmanager.response.TaskResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper mapper;

    @Cacheable(value = "tasks")
    public List<TaskResponse> getAllTasks() {
        return taskRepository.findAllSorted().stream()
                .map(mapper::toTaskResponse)
                .collect(Collectors.toList());
    }

    @Cacheable(value = "task", key = "#taskId")
    public TaskResponse getTaskById(Long taskId) {
        return taskRepository.findById(taskId)
                .map(mapper::toTaskResponse)
                .orElseThrow(() -> new EntityNotFoundException("Task not found with id: " + taskId));
    }

    @CacheEvict(value = "tasks", allEntries = true)
    public String createTask(TaskRequest taskRequest) {
        taskRepository.save(mapper.toTask(taskRequest));
        return "Task created successfully";
    }

    @Caching(evict = {
        @CacheEvict(value = "tasks", allEntries = true)
    }, put = {
        @CachePut(value = "task", key = "#taskId")
    })
    public String updateTask(Long taskId, TaskRequest taskRequest) {
        var task = taskRepository.findById(taskId)
                .orElseThrow(() -> new EntityNotFoundException("Task not found with id: " + taskId));
        task.setTitle(taskRequest.title());
        task.setDescription(taskRequest.description());
        taskRepository.save(task);
        return "Task updated successfully";
    }

    @Caching(evict = {
        @CacheEvict(value = "tasks", allEntries = true)
    }, put = {
        @CachePut(value = "task", key = "#taskId")
    })
    public String completeTask(Long taskId) {
        var task = taskRepository.findById(taskId)
                .orElseThrow(() -> new EntityNotFoundException("Task not found with id: " + taskId));
        Boolean completed = task.getCompleted();
        task.setCompleted(!completed);
        taskRepository.save(task);
        return "Task completed successfully";
    }

    @Caching(evict = {
        @CacheEvict(value = "tasks", allEntries = true),
        @CacheEvict(value = "task", key = "#taskId")
    })
    public void deleteTask(Long taskId) {
        var task = taskRepository.findById(taskId)
                .orElseThrow(() -> new EntityNotFoundException("Task not found with id: " + taskId));
        taskRepository.delete(task);
    }
}
