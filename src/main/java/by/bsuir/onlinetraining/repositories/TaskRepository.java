package by.bsuir.onlinetraining.repositories;

import by.bsuir.onlinetraining.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
