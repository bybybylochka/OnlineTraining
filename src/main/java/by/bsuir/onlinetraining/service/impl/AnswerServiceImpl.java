package by.bsuir.onlinetraining.service.impl;

import by.bsuir.onlinetraining.exception.EntityNotFoundException;
import by.bsuir.onlinetraining.mapper.AnswerMapper;
import by.bsuir.onlinetraining.models.*;
import by.bsuir.onlinetraining.repositories.AnswerRepository;
import by.bsuir.onlinetraining.request.AnswerRequest;
import by.bsuir.onlinetraining.request.CheckAnswerRequest;
import by.bsuir.onlinetraining.request.CompletedCourseUnitRequest;
import by.bsuir.onlinetraining.request.TestCheckRequest;
import by.bsuir.onlinetraining.response.AnswerResponse;
import by.bsuir.onlinetraining.response.list.AnswerListResponse;
import by.bsuir.onlinetraining.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepository answerRepository;
    private final AnswerMapper answerMapper;
    private final CourseUnitService courseUnitService;
    private final StudentService studentService;
    private final CompletedCourseUnitService completedCourseUnitService;
    private final TestService testService;

    @Override
    public Answer findAnswerEntityById(Long answerId) {
        return answerRepository.findById(answerId)
                .orElseThrow(() -> new EntityNotFoundException(answerId, Answer.class));
    }

    @Override
    public AnswerResponse findAnswerById(Long answerId) {
        return answerRepository.findById(answerId)
                .map(answerMapper::mapToAnswerResponse)
                .orElseThrow(() -> new EntityNotFoundException(answerId, Answer.class));
    }

    @Override
    public AnswerResponse createAnswer(AnswerRequest answerRequest) {
        Answer answer = answerMapper.mapToAnswer(answerRequest);
        Answer savedAnswer = answerRepository.save(answer);
        CompletedCourseUnitRequest request = CompletedCourseUnitRequest.builder()
                .courseUnitId(answerRequest.getCourseUnitId())
                .studentId(answerRequest.getStudentId())
                .build();
        completedCourseUnitService.completeCourseUnit(request);

        return answerMapper.mapToAnswerResponse(savedAnswer);
    }

    @Override
    public AnswerResponse createAnswerForTest(TestCheckRequest testCheckRequest) {
        Student student = studentService.findStudentEntityById(testCheckRequest.getStudentId());
        Test test = testService.findTestEntityById(testCheckRequest.getTestId());
        Map<Long, Integer> studentAnswers = testCheckRequest.getAnswers();
        List<Question> questions = test.getQuestions();
        long rightAnswersQuantity = questions.stream()
                .filter(question -> studentAnswers.getOrDefault(question.getId(), -1).equals(question.getCorrectAnswerNumber()))
                .count();
        Answer answer = Answer.builder()
                .student(student)
                .courseUnit(test)
                .mark(calculateMark(questions.size(), rightAnswersQuantity))
                .feedback(createFeedbackForTest(questions.size(), rightAnswersQuantity))
                .build();
        Answer savesAnswer = answerRepository.save(answer);
        return answerMapper.mapToAnswerResponse(savesAnswer);
    }

    @Override
    public AnswerResponse checkAnswer(CheckAnswerRequest checkAnswerRequest) {
        Long answerId = checkAnswerRequest.getId();
        Answer answer = answerRepository.findById(answerId)
                .orElseThrow(() -> new EntityNotFoundException(answerId, Answer.class));
        answer.setMark(checkAnswerRequest.getMark());
        answer.setFeedback(checkAnswerRequest.getFeedback());
        answerRepository.save(answer);
        return answerMapper.mapToAnswerResponse(answer);
    }

    @Override
    public AnswerListResponse findAnswersByCourseUnit(Long courseUnitId) {
        CourseUnit courseUnit = courseUnitService.findCourseUnitEntityById(courseUnitId);
        List<Answer> answers = answerRepository.findAnswersByCourseUnit(courseUnit);

        return new AnswerListResponse(answers.stream()
                .map(answerMapper::mapToAnswerResponse)
                .toList());
    }

    @Override
    public AnswerListResponse findAnswersByCourse(Long courseId) {
        List<CourseUnit> courseUnits = courseUnitService.findAllUnitsEntityByCourse(courseId);
        List<Answer> answers = courseUnits
                .stream()
                .flatMap(courseUnit
                        -> answerRepository.findAnswersByCourseUnit(courseUnit).stream())
                .toList();
        return new AnswerListResponse(answers.stream()
                .map(answerMapper::mapToAnswerResponse)
                .toList());
    }

    @Override
    public AnswerListResponse findAnswersByStudent(Long studentId) {
        Student student = studentService.findStudentEntityById(studentId);
        List<Answer> answers = answerRepository.findAnswersByStudent(student);
        return new AnswerListResponse(answers.stream()
                .map(answerMapper::mapToAnswerResponse)
                .toList());
    }

    private int calculateMark(int questionsQuantity, long rightQuestionsQuantity) {
        double rightAnswersCoefficient = (double) rightQuestionsQuantity / questionsQuantity;
        return (int) (rightAnswersCoefficient * 100);
    }

    private String createFeedbackForTest(int questionsQuantity, long rightQuestionsQuantity){
        return String.format("Правильно выполнено %s вопросов из %s", rightQuestionsQuantity, questionsQuantity);
    }
}
