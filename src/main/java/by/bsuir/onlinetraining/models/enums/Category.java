package by.bsuir.onlinetraining.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Category {
    PROGRAMMING("programming"),
    DESIGN("design"),
    BUSINESS("business"),
    MARKETING("marketing"),
    GAMING("gaming"),
    MUSIC("music"),
    PSYCHOLOGY("psychology"),
    HEALTH("health"),
    LANGUAGES("foreign-languages"),
    FINANCE("finance"),
    OTHER("other");

    private final String description;
}