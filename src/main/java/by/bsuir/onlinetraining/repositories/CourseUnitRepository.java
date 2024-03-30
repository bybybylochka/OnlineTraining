package by.bsuir.onlinetraining.repositories;

import by.bsuir.onlinetraining.models.Course;
import by.bsuir.onlinetraining.models.CourseUnit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseUnitRepository extends JpaRepository<CourseUnit, Long> {

    List<CourseUnit> findCourseUnitsByCourse(Course course);

}
