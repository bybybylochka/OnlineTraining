package by.bsuir.onlinetraining.service;

import by.bsuir.onlinetraining.models.CourseUnit;
import by.bsuir.onlinetraining.response.CourseUnitResponse;
import by.bsuir.onlinetraining.response.list.CourseUnitListResponse;

import java.util.List;

public interface CourseUnitService {
    CourseUnit findCourseUnitEntityById(Long courseUnitId);

    CourseUnitResponse findCourseUnitById(Long courseUnitId);

    CourseUnitListResponse findAllUnitsByCourse(Long courseId);

    List<CourseUnit> findAllUnitsEntityByCourse(Long courseId);

    void deleteCourseUnit(Long courseUnitId);
}
