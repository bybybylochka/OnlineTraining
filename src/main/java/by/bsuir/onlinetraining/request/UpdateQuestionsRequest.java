package by.bsuir.onlinetraining.request;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class UpdateQuestionsRequest {
    private Map<Long, QuestionRequest> updatedQuestions;
}
