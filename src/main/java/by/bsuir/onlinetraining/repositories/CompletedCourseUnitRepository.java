package by.bsuir.onlinetraining.repositories;

import by.bsuir.onlinetraining.models.CompletedCourseUnit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompletedCourseUnitRepository extends JpaRepository<CompletedCourseUnit, Long> {
}
