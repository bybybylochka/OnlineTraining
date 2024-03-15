package by.bsuir.onlinetraining.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {
    STUDENT("ROLE_STUDENT"),
    MENTOR("ROLE_MENTOR"),
    ENTREPRENEUR("ROLE_ENTREPRENEUR"),
    ADMIN("ROLE_ADMIN");

    private final String name;
}
