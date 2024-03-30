package by.bsuir.onlinetraining.repositories;

import by.bsuir.onlinetraining.models.Course;
import by.bsuir.onlinetraining.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findTasksByCourse(Course course);
}
