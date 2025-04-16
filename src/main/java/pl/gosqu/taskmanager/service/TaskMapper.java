package pl.gosqu.taskmanager.service;

import org.springframework.stereotype.Service;
import pl.gosqu.taskmanager.entity.Task;
import pl.gosqu.taskmanager.request.TaskRequest;
import pl.gosqu.taskmanager.response.TaskResponse;

@Service
public class TaskMapper {

    public Task toTask(TaskRequest request) {
        return Task.builder()
                .title(request.title())
                .description(request.description())
                .completed(false)
                .build();
    }

    public TaskResponse toTaskResponse(Task task) {
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getCompleted(),
                task.getCreatedAt()
        );
    }
}
