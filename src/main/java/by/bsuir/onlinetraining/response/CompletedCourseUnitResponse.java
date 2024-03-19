package by.bsuir.onlinetraining.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompletedCourseUnitResponse {
    private Long id;
    private Long studentId;
    private Long courseUnitId;
    private String courseUnitName;
}
