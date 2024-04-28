package by.bsuir.onlinetraining.response;

import by.bsuir.onlinetraining.models.enums.Category;
import by.bsuir.onlinetraining.models.enums.CourseStatus;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@ToString
public class CourseResponse {
    private Long id;
    private MentorResponse mentor;
    private EntrepreneurResponse entrepreneur;
    private String name;
    private String description;
    private CourseStatus status;
    private BigDecimal price;
    private Category category;
    private String paymentLink;
    @ToString.Exclude
    private byte[] image;
    private List<CourseUnitResponse> courseUnitList;
}
