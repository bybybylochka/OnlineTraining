package by.bsuir.onlinetraining.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LessonRequest {
    private CourseUnitRequest basicInfo;
    private String content;
}
