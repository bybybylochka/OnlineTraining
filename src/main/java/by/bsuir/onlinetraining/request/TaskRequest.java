package by.bsuir.onlinetraining.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class TaskRequest extends CourseUnitRequest {
    private String description;
    private int maximumScore;
}
