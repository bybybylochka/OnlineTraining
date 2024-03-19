package by.bsuir.onlinetraining.service;

import by.bsuir.onlinetraining.models.CourseUnit;
import by.bsuir.onlinetraining.response.CourseUnitResponse;
import by.bsuir.onlinetraining.response.list.CourseUnitListResponse;

public interface CourseUnitService {
    CourseUnit findCourseUnitEntityById(Long courseUnitId);

    CourseUnitResponse findCourseUnitById(Long courseUnitId);

    CourseUnitListResponse findAllCourseUnits();

    void deleteCourseUnit(Long courseUnitId);
}
