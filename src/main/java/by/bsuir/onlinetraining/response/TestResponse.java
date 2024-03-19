package by.bsuir.onlinetraining.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TestResponse {
    private CourseUnitResponse basicInfo;
    private List<QuestionResponse> questionList;
}
