package by.bsuir.onlinetraining.exception;

import by.bsuir.onlinetraining.models.enums.CourseStatus;

public class ModifyIsNotAllowedException extends RuntimeException {
    public ModifyIsNotAllowedException(CourseStatus status) {
        super(String.format("Course with %s status can't be modified", status.name()));
    }
}