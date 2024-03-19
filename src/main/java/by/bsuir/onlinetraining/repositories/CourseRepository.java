package by.bsuir.onlinetraining.repositories;

import by.bsuir.onlinetraining.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
