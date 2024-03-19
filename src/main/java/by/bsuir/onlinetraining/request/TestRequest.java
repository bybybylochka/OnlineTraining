package by.bsuir.onlinetraining.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class TestRequest extends CourseUnitRequest {
    private List<QuestionRequest> questionList;
}
