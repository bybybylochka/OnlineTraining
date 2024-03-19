package by.bsuir.onlinetraining.repositories;

import by.bsuir.onlinetraining.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
