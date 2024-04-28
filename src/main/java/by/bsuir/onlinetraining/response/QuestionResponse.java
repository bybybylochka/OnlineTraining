package by.bsuir.onlinetraining.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuestionResponse {
    private Long id;
    private Long testId;
    private String questionContent;
    private String answers;
    private int correctAnswerNumber;
}
