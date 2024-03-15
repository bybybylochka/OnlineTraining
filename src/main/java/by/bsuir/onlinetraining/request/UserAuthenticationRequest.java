package by.bsuir.onlinetraining.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserAuthenticationRequest {
    private String login;
    private String password;
}
