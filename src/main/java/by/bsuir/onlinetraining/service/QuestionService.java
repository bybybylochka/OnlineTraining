package by.bsuir.onlinetraining.service;

import by.bsuir.onlinetraining.models.Question;
import by.bsuir.onlinetraining.request.UpdateQuestionsRequest;
import by.bsuir.onlinetraining.response.list.UpdatedQuestionsResponse;

import java.util.List;

public interface QuestionService {

    UpdatedQuestionsResponse updateQuestions(UpdateQuestionsRequest request);

    List<Question> uploadQuestions(List<Question> questions);
}
