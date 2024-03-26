package by.bsuir.onlinetraining.repositories;

import by.bsuir.onlinetraining.models.Answer;
import by.bsuir.onlinetraining.models.CourseUnit;
import by.bsuir.onlinetraining.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findAnswersByCourseUnit(CourseUnit courseUnit);
    List<Answer> findAnswersByStudent(Student student);
}
