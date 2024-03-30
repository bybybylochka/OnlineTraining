package by.bsuir.onlinetraining.service;

import by.bsuir.onlinetraining.models.PurchasedCourse;
import by.bsuir.onlinetraining.request.PurchasedCourseRequest;
import by.bsuir.onlinetraining.response.PurchasedCourseResponse;
import by.bsuir.onlinetraining.response.list.PurchasedCourseListResponse;

public interface PurchasedCourseService {
    PurchasedCourse findCourseEntityById(Long courseId);

    PurchasedCourseResponse findCourseById(Long courseId);

    PurchasedCourseListResponse findCoursesByStudent(Long studentId);

    PurchasedCourseListResponse findCoursesByCourse(Long courseId);

    PurchasedCourseResponse purchaseCourse(PurchasedCourseRequest courseRequest);
}
