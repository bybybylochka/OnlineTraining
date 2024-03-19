package by.bsuir.onlinetraining.repositories;

import by.bsuir.onlinetraining.models.PurchasedCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchasedCourseRepository extends JpaRepository<PurchasedCourse, Long> {
}
