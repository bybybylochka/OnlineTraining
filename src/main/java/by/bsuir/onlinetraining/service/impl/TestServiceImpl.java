package by.bsuir.onlinetraining.service.impl;

import by.bsuir.onlinetraining.exception.EntityNotFoundException;
import by.bsuir.onlinetraining.mapper.TestMapper;
import by.bsuir.onlinetraining.models.Test;
import by.bsuir.onlinetraining.repositories.TestRepository;
import by.bsuir.onlinetraining.response.TestResponse;
import by.bsuir.onlinetraining.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {
    private final TestRepository testRepository;
    private final TestMapper testMapper;

    @Override
    public Test findTestEntityById(Long testId) {
        return testRepository.findById(testId)
                .orElseThrow(() -> new EntityNotFoundException(testId, Test.class));
    }

    @Override
    public TestResponse findTestById(Long testId) {
        return testRepository.findById(testId)
                .map(testMapper::mapToTestResponse)
                .orElseThrow(() -> new IllegalArgumentException("Test was not found by id!"));
    }
}
