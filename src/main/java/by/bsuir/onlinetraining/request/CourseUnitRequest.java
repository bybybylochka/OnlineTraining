package by.bsuir.onlinetraining.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CourseUnitRequest {
    private Long courseId;
    private int estimatedTimeInMinutes;
    private String name;
}
