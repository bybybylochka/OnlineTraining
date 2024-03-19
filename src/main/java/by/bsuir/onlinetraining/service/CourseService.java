package by.bsuir.onlinetraining.service;

import by.bsuir.onlinetraining.models.Course;
import by.bsuir.onlinetraining.models.enums.Category;
import by.bsuir.onlinetraining.models.enums.CourseStatus;
import by.bsuir.onlinetraining.request.CourseRequest;
import by.bsuir.onlinetraining.response.CourseResponse;
import by.bsuir.onlinetraining.response.list.CourseListResponse;

public interface CourseService {
    Course findCourseEntityById(Long courseId);

    CourseResponse findCourseById(Long courseId);

    CourseListResponse findAllCourses();

    CourseListResponse findCoursesByEntrepreneur(Long entrepreneurId);

    CourseListResponse findCoursesByCategory(Category category);

    CourseResponse createCourse(CourseRequest courseRequest);

    CourseResponse editCourse(Long courseId, CourseRequest courseRequest);

    void deleteCourse(Long courseId);

    CourseResponse changeCourseStatus(Long courseId, CourseStatus courseStatus);
}
