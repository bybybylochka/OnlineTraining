package by.bsuir.onlinetraining.service;

import by.bsuir.onlinetraining.models.Test;
import by.bsuir.onlinetraining.request.TestRequest;
import by.bsuir.onlinetraining.request.UpdateTestRequest;
import by.bsuir.onlinetraining.response.TestResponse;
import by.bsuir.onlinetraining.response.list.TestListResponse;

public interface TestService {
    Test findTestEntityById(Long testId);

    TestResponse findTestById(Long testId);

    TestListResponse findTestsByCourse(Long courseId);

    TestResponse createTest(TestRequest testRequest);

    TestResponse editTest(UpdateTestRequest testRequest);



    void deleteTest(Long testId);
}
