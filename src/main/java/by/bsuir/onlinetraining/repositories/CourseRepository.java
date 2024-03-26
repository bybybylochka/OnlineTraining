package by.bsuir.onlinetraining.repositories;

import by.bsuir.onlinetraining.models.Course;
import by.bsuir.onlinetraining.models.Entrepreneur;
import by.bsuir.onlinetraining.models.enums.Category;
import by.bsuir.onlinetraining.models.enums.CourseStatus;
import ch.qos.logback.core.status.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findCoursesByEntrepreneur(Entrepreneur entrepreneur);
    List<Course> findCoursesByCategory(Category category);
}
