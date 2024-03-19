package by.bsuir.onlinetraining.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PurchasedCourseRequest {
    private Long courseId;
    private Long studentId;
}
