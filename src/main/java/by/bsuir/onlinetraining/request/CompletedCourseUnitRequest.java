package by.bsuir.onlinetraining.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompletedCourseUnitRequest {
    private Long studentId;
    private Long courseUnitId;
}
