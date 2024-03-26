package by.bsuir.onlinetraining.service.impl;

import by.bsuir.onlinetraining.exception.EntityNotFoundException;
import by.bsuir.onlinetraining.mapper.AnswerMapper;
import by.bsuir.onlinetraining.models.Answer;
import by.bsuir.onlinetraining.models.Course;
import by.bsuir.onlinetraining.models.CourseUnit;
import by.bsuir.onlinetraining.models.Student;
import by.bsuir.onlinetraining.repositories.AnswerRepository;
import by.bsuir.onlinetraining.request.AnswerRequest;
import by.bsuir.onlinetraining.request.CheckAnswerRequest;
import by.bsuir.onlinetraining.response.AnswerResponse;
import by.bsuir.onlinetraining.response.list.AnswerListResponse;
import by.bsuir.onlinetraining.service.AnswerService;
import by.bsuir.onlinetraining.service.CourseUnitService;
import by.bsuir.onlinetraining.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepository answerRepository;
    private final AnswerMapper answerMapper;
    private final CourseUnitService courseUnitService;
    private final StudentService studentService;
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
        answerRepository.save(answer);
        return answerMapper.mapToAnswerResponse(answer);
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
    public AnswerListResponse findAnswersByStudent(Long studentId) {
        Student student = studentService.findStudentEntityById(studentId);
        List<Answer> answers = answerRepository.findAnswersByStudent(student);
        return new AnswerListResponse(answers.stream()
                .map(answerMapper::mapToAnswerResponse)
                .toList());
    }
}
