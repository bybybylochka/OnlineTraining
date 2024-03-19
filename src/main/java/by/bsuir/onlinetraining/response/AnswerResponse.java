package by.bsuir.onlinetraining.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class AnswerResponse {
    private Long id;
    private Long courseId;
    private String courseName;
    private Long courseUnitId;
    private String courseUnitName;
    private Long studentId;
    private String link;
    private int mark;
    private String feedback;
    private LocalDate createdAt;
}
