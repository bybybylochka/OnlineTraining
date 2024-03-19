package by.bsuir.onlinetraining.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MentorResponse {
    private Long id;
    private String fullName;
    private String characteristic;
    private int experience;
}
