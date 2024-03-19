package by.bsuir.onlinetraining.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskResponse {
    private CourseUnitResponse basicInfo;
    private String description;
    private int maximumScore;
}
