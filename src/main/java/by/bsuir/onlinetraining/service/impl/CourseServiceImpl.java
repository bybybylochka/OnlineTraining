package by.bsuir.onlinetraining.service.impl;

import by.bsuir.onlinetraining.exception.EntityNotFoundException;
import by.bsuir.onlinetraining.mapper.CourseMapper;
import by.bsuir.onlinetraining.models.Course;
import by.bsuir.onlinetraining.models.Entrepreneur;
import by.bsuir.onlinetraining.models.enums.Category;
import by.bsuir.onlinetraining.models.enums.CourseStatus;
import by.bsuir.onlinetraining.repositories.CourseRepository;
import by.bsuir.onlinetraining.request.CourseRequest;
import by.bsuir.onlinetraining.response.CourseResponse;
import by.bsuir.onlinetraining.response.list.CourseListResponse;
import by.bsuir.onlinetraining.service.CourseService;
import by.bsuir.onlinetraining.service.EntrepreneurService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final EntrepreneurService entrepreneurService;

    @Override
    public Course findCourseEntityById(Long courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new EntityNotFoundException(courseId, Course.class));
    }

    @Override
    public CourseResponse findCourseById(Long courseId) {
        return courseRepository.findById(courseId)
                .map(courseMapper::mapToCourseResponse)
                .orElseThrow(() -> new EntityNotFoundException(courseId, Course.class));
    }

    @Override
    public CourseListResponse findAllCourses() {
        return new CourseListResponse(courseRepository.findAll()
                .stream()
                .map(courseMapper::mapToCourseResponse)
                .toList());
    }

    @Override
    public CourseListResponse findCoursesByEntrepreneur(Long entrepreneurId) {
        Entrepreneur entrepreneur = entrepreneurService.findEntrepreneurEntityById(entrepreneurId);
        List<Course> courses = courseRepository.findCoursesByEntrepreneur(entrepreneur);

        return new CourseListResponse(courses
                .stream()
                .map(courseMapper::mapToCourseResponse)
                .toList());
    }

    @Override
    public CourseListResponse findCoursesByCategory(Category category) {
        return new CourseListResponse(courseRepository
                .findCoursesByCategory(category)
                .stream()
                .map(courseMapper::mapToCourseResponse)
                .toList());

    }

    @Override
    public CourseResponse createCourse(CourseRequest courseRequest) {
        Course course = courseMapper.mapToCourse(courseRequest);
        courseRepository.save(course);
        return courseMapper.mapToCourseResponse(course);
    }

    @Override
    public CourseResponse editCourse(Long courseId, CourseRequest courseRequest) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new EntityNotFoundException(courseId, Course.class));
        courseMapper.updateCourse(courseRequest, course);
        Course updatedCourse = courseRepository.save(course);

        return courseMapper.mapToCourseResponse(updatedCourse);
    }

    @Override
    public void deleteCourse(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new EntityNotFoundException(courseId, Course.class));
        courseRepository.delete(course);

    }

    @Override
    public CourseResponse changeCourseStatus(Long courseId, CourseStatus courseStatus) {
        //TODO Add validation
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new EntityNotFoundException(courseId, Course.class));
        course.setStatus(courseStatus);
        courseRepository.save(course);
        return courseMapper.mapToCourseResponse(course);
    }
}
