package by.bsuir.onlinetraining.service;

import by.bsuir.onlinetraining.request.UpdateQuestionsRequest;
import by.bsuir.onlinetraining.response.list.UpdatedQuestionsResponse;

public interface QuestionService {
    UpdatedQuestionsResponse updateQuestions(UpdateQuestionsRequest request);
}
