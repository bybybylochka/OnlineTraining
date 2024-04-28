package by.bsuir.onlinetraining.response;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class MentorResponse {
    private Long id;
    private String login;
    private String fullName;
    private String characteristic;
    private int experience;
    @ToString.Exclude
    private byte[] image;
}
