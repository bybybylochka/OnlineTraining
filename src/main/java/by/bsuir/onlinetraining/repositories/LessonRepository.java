package by.bsuir.onlinetraining.repositories;

import by.bsuir.onlinetraining.models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
