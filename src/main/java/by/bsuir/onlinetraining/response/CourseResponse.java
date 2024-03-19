package by.bsuir.onlinetraining.response;

import by.bsuir.onlinetraining.models.enums.Category;
import by.bsuir.onlinetraining.models.enums.CourseStatus;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class CourseResponse {
    private Long id;
    private MentorResponse mentor;
    private EntrepreneurResponse entrepreneur;
    private String name;
    private String description;
    private CourseStatus status;
    private BigDecimal price;
    private Category category;
    private List<CourseUnitResponse> courseUnitList;
}
