package by.bsuir.onlinetraining.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentRatingResponse {
    private Long studentId;
    private String fullName;
    private double lessonPercent;
    private double taskPercent;
    private double testPercent;
    private double pointPercent;
}
