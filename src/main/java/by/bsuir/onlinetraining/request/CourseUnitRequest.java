package by.bsuir.onlinetraining.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CourseUnitRequest {
    private Long courseId;
//    private int estimatedTime;
    private String name;
}
