package by.bsuir.onlinetraining.service;

import by.bsuir.onlinetraining.models.Course;
import by.bsuir.onlinetraining.models.enums.Category;
import by.bsuir.onlinetraining.models.enums.CourseStatus;
import by.bsuir.onlinetraining.request.CourseRequest;
import by.bsuir.onlinetraining.response.CourseResponse;
import by.bsuir.onlinetraining.response.list.CourseListResponse;
import org.springframework.web.multipart.MultipartFile;

public interface CourseService {
    Course findCourseEntityById(Long courseId);

    CourseResponse findCourseById(Long courseId);

    CourseListResponse findAllCourses();

    CourseListResponse findCoursesByEntrepreneur();

    CourseListResponse findCoursesByMentor();

    CourseListResponse findCoursesByCategory(Category category);

    CourseListResponse findCoursesByStatus(CourseStatus status);

    CourseResponse createCourse(CourseRequest courseRequest, MultipartFile image);

    CourseResponse editCourse(Long courseId, CourseRequest courseRequest);

    void deleteCourse(Long courseId);

    CourseResponse changeCourseStatus(Long courseId, CourseStatus courseStatus);
}
