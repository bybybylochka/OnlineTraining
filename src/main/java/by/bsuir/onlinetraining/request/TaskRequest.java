package by.bsuir.onlinetraining.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskRequest {
    private CourseUnitRequest basicInfo;
    private String description;
    private int maximumScore;
}
