package by.bsuir.onlinetraining.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Category {
    IT("it-technologies"),
    LANGUAGES("foreign-languages"),
    MARKETING("marketing");

    private final String description;
}