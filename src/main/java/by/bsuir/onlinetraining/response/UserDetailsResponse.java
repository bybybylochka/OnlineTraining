package by.bsuir.onlinetraining.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDetailsResponse {
    private boolean tokenValid;
    private String role;
}
