package by.bsuir.onlinetraining.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MentorRegistrationRequest {
    private String login;
    private String password;
    private String fullName;
    private String characteristic;
    private int experience;
}
