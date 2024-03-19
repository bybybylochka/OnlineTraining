package by.bsuir.onlinetraining.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnswerRequest {
    private Long courseUnitId;
    private Long studentId;
    private String link;
}
