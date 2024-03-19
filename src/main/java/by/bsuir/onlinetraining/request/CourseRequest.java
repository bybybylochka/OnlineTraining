package by.bsuir.onlinetraining.request;

import by.bsuir.onlinetraining.models.enums.Category;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CourseRequest {
    private Long mentorId;
    private Long entrepreneurId;
    private String name;
    private String description;
    private BigDecimal price;
    private Category category;
}
