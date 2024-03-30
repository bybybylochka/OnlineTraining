package by.bsuir.onlinetraining.exception;

import by.bsuir.onlinetraining.models.enums.CourseStatus;

public class InvalidNewCourseStatusException extends RuntimeException {
    public InvalidNewCourseStatusException(CourseStatus oldStatus, CourseStatus newStatus) {
        super(String.format("%s status can't be set when current status is %s", newStatus.name(), oldStatus.name()));
    }
}
