package by.bsuir.onlinetraining.request;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TestRequest {
    private CourseUnitRequest basicInfo;
    private List<QuestionRequest> questionList;
}
