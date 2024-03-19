package by.bsuir.onlinetraining.response;

import by.bsuir.onlinetraining.models.enums.CompletingStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PurchasedCourseResponse {
    private Long id;
    private Long courseId;
    private String courseName;
    private Long studentId;
    private CompletingStatus completingStatus;
}
