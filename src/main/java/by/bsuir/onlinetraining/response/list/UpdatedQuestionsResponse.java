package by.bsuir.onlinetraining.response.list;

import by.bsuir.onlinetraining.response.QuestionResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UpdatedQuestionsResponse {
    private List<QuestionResponse> updatedQuestions;
}
