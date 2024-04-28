package by.bsuir.onlinetraining.service;

import by.bsuir.onlinetraining.request.CompletedCourseUnitRequest;
import by.bsuir.onlinetraining.request.SearchCompletedUnitsRequest;
import by.bsuir.onlinetraining.response.CompletedCourseUnitResponse;
import by.bsuir.onlinetraining.response.list.CompletedUnitListResponse;

public interface CompletedCourseUnitService {
    CompletedCourseUnitResponse completeCourseUnit(CompletedCourseUnitRequest completedCourseUnitRequest);

    CompletedUnitListResponse findCompletedUnits(SearchCompletedUnitsRequest searchCompletedUnitsRequest);

//    StudentRatingListResponse findStudentsRating(Long courseId);
}
