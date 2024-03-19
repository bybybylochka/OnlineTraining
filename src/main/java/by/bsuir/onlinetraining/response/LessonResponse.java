package by.bsuir.onlinetraining.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LessonResponse {
    private CourseUnitResponse basicInfo;
    private String content;
}
