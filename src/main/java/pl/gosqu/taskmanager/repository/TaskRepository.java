package pl.gosqu.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.gosqu.taskmanager.entity.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("SELECT t FROM Task t ORDER BY t.completed ASC, t.id ASC")
    List<Task> findAllSorted();

}
