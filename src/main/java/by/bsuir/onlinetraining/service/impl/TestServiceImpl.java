package by.bsuir.onlinetraining.service.impl;

import by.bsuir.onlinetraining.exception.EntityNotFoundException;
import by.bsuir.onlinetraining.exception.ModifyIsNotAllowedException;
import by.bsuir.onlinetraining.mapper.TestMapper;
import by.bsuir.onlinetraining.models.Test;
import by.bsuir.onlinetraining.models.enums.CourseStatus;
import by.bsuir.onlinetraining.repositories.TestRepository;
import by.bsuir.onlinetraining.request.TestRequest;
import by.bsuir.onlinetraining.request.UpdateTestRequest;
import by.bsuir.onlinetraining.response.TestResponse;
import by.bsuir.onlinetraining.service.QuestionService;
import by.bsuir.onlinetraining.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {
    private final TestRepository testRepository;
    private final TestMapper testMapper;
    private final QuestionService questionService;

    @Override
    public Test findTestEntityById(Long testId) {
        return testRepository.findById(testId)
                .orElseThrow(() -> new EntityNotFoundException(testId, Test.class));
    }

    @Override
    public TestResponse findTestById(Long testId) {
        return testRepository.findById(testId)
                .map(testMapper::mapToTestResponse)
                .orElseThrow(() -> new EntityNotFoundException(testId, Test.class));
    }

    @Override
    public TestResponse createTest(TestRequest testRequest) {
        Test test = testMapper.mapToTest(testRequest);
        validateCourseStatus(test);
        Test savedTest = testRepository.save(test);

        return testMapper.mapToTestResponse(savedTest);
    }

    @Override
    public TestResponse editTest(UpdateTestRequest testRequest) {
        Test test = testRepository.findById(testRequest.getTestId())
                .orElseThrow(() -> new EntityNotFoundException(testRequest.getTestId(), Test.class));
        validateCourseStatus(test);
        questionService.updateQuestions(testRequest.getRequest());

        return testMapper.mapToTestResponse(test);
    }

    @Override
    public void deleteTest(Long testId) {
        Test test = testRepository.findById(testId)
                .orElseThrow(() -> new EntityNotFoundException(testId, Test.class));
        validateCourseStatus(test);
        testRepository.delete(test);
    }

    private static void validateCourseStatus(Test test) {
        CourseStatus status = test.getCourse().getStatus();
        if (!status.equals(CourseStatus.NOT_FILLED_IN))
            throw new ModifyIsNotAllowedException(status);
    }
}
