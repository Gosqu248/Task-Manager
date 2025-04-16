package pl.gosqu.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.gosqu.taskmanager.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
