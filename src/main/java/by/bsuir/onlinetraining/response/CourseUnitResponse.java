package by.bsuir.onlinetraining.response;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.Duration;

@Data
@SuperBuilder
public class CourseUnitResponse {
    private Long id;
    private Long courseId;
    private Duration estimatedTime;
    private String name;
}
