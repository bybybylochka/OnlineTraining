package by.bsuir.onlinetraining.response;

import lombok.Builder;
import lombok.Data;

import java.time.Duration;

@Data
@Builder
public class CourseUnitResponse {
    private Long id;
    private Long courseId;
    private Duration estimatedTime;
    private String name;
}
