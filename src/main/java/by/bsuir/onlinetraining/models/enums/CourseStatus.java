package by.bsuir.onlinetraining.models.enums;

import lombok.AllArgsConstructor;

import java.util.Collections;
import java.util.List;

@AllArgsConstructor
public enum CourseStatus {
    NOT_FILLED_IN(Collections.emptyList()),
    FILLED_IN(List.of(NOT_FILLED_IN)),
    UNDER_INSPECTION(List.of(FILLED_IN)),
    APPROVED(List.of(UNDER_INSPECTION)),
    INACTIVE(List.of(APPROVED));

    private final List<CourseStatus> beforeStatusList;

    public boolean isAllowed(CourseStatus oldStatus) {
        return beforeStatusList.contains(oldStatus);
    }
}