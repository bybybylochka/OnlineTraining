package by.bsuir.onlinetraining.repositories;

import by.bsuir.onlinetraining.models.Question;
import by.bsuir.onlinetraining.models.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findQuestionsByTest(Test test);
}
