package by.bsuir.onlinetraining.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class LessonRequest extends CourseUnitRequest {
    private String content;
}
