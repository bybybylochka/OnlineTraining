package by.bsuir.onlinetraining.repositories;

import by.bsuir.onlinetraining.models.Course;
import by.bsuir.onlinetraining.models.PurchasedCourse;
import by.bsuir.onlinetraining.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchasedCourseRepository extends JpaRepository<PurchasedCourse, Long> {
    List<PurchasedCourse> findPurchasedCoursesByStudent(Student student);
    List<PurchasedCourse> findPurchasedCoursesByCourse(Course course);
}
