package by.bsuir.onlinetraining.repositories;

import by.bsuir.onlinetraining.models.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
}
