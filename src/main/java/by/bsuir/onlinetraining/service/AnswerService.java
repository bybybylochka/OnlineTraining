package by.bsuir.onlinetraining.service;

import by.bsuir.onlinetraining.models.Answer;
import by.bsuir.onlinetraining.request.AnswerRequest;
import by.bsuir.onlinetraining.request.CheckAnswerRequest;
import by.bsuir.onlinetraining.request.TestCheckRequest;
import by.bsuir.onlinetraining.response.AnswerResponse;
import by.bsuir.onlinetraining.response.list.AnswerListResponse;

public interface AnswerService {
    Answer findAnswerEntityById(Long answerId);

    AnswerResponse findAnswerById(Long answerId);

    AnswerResponse createAnswer(AnswerRequest answerRequest);

    AnswerResponse createAnswerForTest(TestCheckRequest testCheckRequest);

    AnswerResponse checkAnswer(CheckAnswerRequest checkAnswerRequest);

    AnswerListResponse findAnswersByCourseUnit(Long courseUnitId);

    AnswerListResponse findAnswersByCourse(Long courseId);

    AnswerListResponse findAnswersByStudent(Long studentId);
}
