package by.bsuir.onlinetraining.repositories;

import by.bsuir.onlinetraining.models.Course;
import by.bsuir.onlinetraining.models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
    List<Lesson> findLessonsByCourse(Course course);
}
