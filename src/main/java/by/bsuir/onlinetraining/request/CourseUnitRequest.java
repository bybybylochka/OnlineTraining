package by.bsuir.onlinetraining.request;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class CourseUnitRequest {
    private Long courseId;
    private int estimatedTimeInMinutes;
    private String name;
}
