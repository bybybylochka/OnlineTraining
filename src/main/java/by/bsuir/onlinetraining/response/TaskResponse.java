package by.bsuir.onlinetraining.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class TaskResponse extends CourseUnitResponse {
    private String description;
    private int maximumScore;
}
