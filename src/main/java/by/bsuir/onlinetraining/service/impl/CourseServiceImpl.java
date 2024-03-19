package by.bsuir.onlinetraining.service.impl;

import by.bsuir.onlinetraining.models.Course;
import by.bsuir.onlinetraining.models.enums.Category;
import by.bsuir.onlinetraining.models.enums.CourseStatus;
import by.bsuir.onlinetraining.repositories.CourseRepository;
import by.bsuir.onlinetraining.request.CourseRequest;
import by.bsuir.onlinetraining.response.CourseResponse;
import by.bsuir.onlinetraining.response.list.CourseListResponse;
import by.bsuir.onlinetraining.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Override
    public Course findCourseEntityById(Long courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("Course wan not fount by id!"));
    }

    @Override
    public CourseResponse findCourseById(Long courseId) {
        return null;
    }

    @Override
    public CourseListResponse findAllCourses() {
        return null;
    }

    @Override
    public CourseListResponse findCoursesByEntrepreneur(Long entrepreneurId) {
        return null;
    }

    @Override
    public CourseListResponse findCoursesByCategory(Category category) {
        return null;
    }

    @Override
    public CourseResponse createCourse(CourseRequest courseRequest) {
        return null;
    }

    @Override
    public CourseResponse editCourse(Long courseId, CourseRequest courseRequest) {
        return null;
    }

    @Override
    public void deleteCourse(Long courseId) {

    }

    @Override
    public CourseResponse changeCourseStatus(Long courseId, CourseStatus courseStatus) {
        return null;
    }
}
