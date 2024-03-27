package by.bsuir.onlinetraining.repositories;

import by.bsuir.onlinetraining.models.CompletedCourseUnit;
import by.bsuir.onlinetraining.models.Course;
import by.bsuir.onlinetraining.models.CourseUnit;
import by.bsuir.onlinetraining.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompletedCourseUnitRepository extends JpaRepository<CompletedCourseUnit, Long> {
    List<CompletedCourseUnit> findCompletedCourseUnitsByStudent(Student student);
}
