package by.bsuir.onlinetraining.service.impl;

import by.bsuir.onlinetraining.mapper.QuestionMapper;
import by.bsuir.onlinetraining.models.Question;
import by.bsuir.onlinetraining.repositories.QuestionRepository;
import by.bsuir.onlinetraining.request.QuestionRequest;
import by.bsuir.onlinetraining.request.UpdateQuestionsRequest;
import by.bsuir.onlinetraining.response.list.UpdatedQuestionsResponse;
import by.bsuir.onlinetraining.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;

    @Override
    public UpdatedQuestionsResponse updateQuestions(UpdateQuestionsRequest request) {
        Map<Long, QuestionRequest> updatedQuestions = request.getUpdatedQuestions();
        List<Question> questionsToUpdate = questionRepository.findAllById(updatedQuestions.keySet());
        questionsToUpdate.forEach(question ->
                questionMapper.updateQuestion(updatedQuestions.get(question.getId()), question)
        );
        questionRepository.saveAll(questionsToUpdate);

        return new UpdatedQuestionsResponse(questionsToUpdate
                .stream()
                .map(questionMapper::mapToQuestionResponse)
                .toList()
        );
    }

    @Override
    public List<Question> uploadQuestions(List<Question> questions) {
        return questionRepository.saveAll(questions);
    }
}
