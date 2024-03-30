package by.bsuir.onlinetraining.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateTestRequest {
    private Long testId;
    private UpdateQuestionsRequest request;
}
