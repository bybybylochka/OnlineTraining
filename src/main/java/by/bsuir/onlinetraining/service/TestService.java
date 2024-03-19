package by.bsuir.onlinetraining.service;

import by.bsuir.onlinetraining.models.Test;
import by.bsuir.onlinetraining.response.TestResponse;

public interface TestService {
    Test findTestEntityById(Long testId);

    TestResponse findTestById(Long testId);
}
