package by.bsuir.onlinetraining.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EditMentorRequest {
    private String fullName;
    private String characteristic;
    private int experience;
}
