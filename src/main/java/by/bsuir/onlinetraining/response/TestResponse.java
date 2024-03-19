package by.bsuir.onlinetraining.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class TestResponse extends CourseUnitResponse {
    private List<QuestionResponse> questionList;
}
