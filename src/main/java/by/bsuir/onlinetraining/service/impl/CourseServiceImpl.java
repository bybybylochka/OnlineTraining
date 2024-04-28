package by.bsuir.onlinetraining.service.impl;

import by.bsuir.onlinetraining.exception.EntityNotFoundException;
import by.bsuir.onlinetraining.exception.InvalidNewCourseStatusException;
import by.bsuir.onlinetraining.exception.ModifyIsNotAllowedException;
import by.bsuir.onlinetraining.mapper.CourseMapper;
import by.bsuir.onlinetraining.models.Course;
import by.bsuir.onlinetraining.models.Entrepreneur;
import by.bsuir.onlinetraining.models.Mentor;
import by.bsuir.onlinetraining.models.enums.Category;
import by.bsuir.onlinetraining.models.enums.CourseStatus;
import by.bsuir.onlinetraining.repositories.CourseRepository;
import by.bsuir.onlinetraining.request.CourseRequest;
import by.bsuir.onlinetraining.response.CourseResponse;
import by.bsuir.onlinetraining.response.list.CourseListResponse;
import by.bsuir.onlinetraining.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final EntrepreneurService entrepreneurService;
    private final MentorService mentorService;
    private final ImageService imageService;
    private final StripeService stripeService;

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
    public CourseListResponse findCoursesByEntrepreneur() {
        Entrepreneur entrepreneur = entrepreneurService.doGetAuthenticatedEntrepreneur();
        List<Course> courses = courseRepository.findCoursesByEntrepreneur(entrepreneur);

        return new CourseListResponse(courses
                .stream()
                .map(courseMapper::mapToCourseResponse)
                .toList());
    }

    @Override
    public CourseListResponse findCoursesByMentor() {
        Mentor mentor = mentorService.doGetAuthenticatedMentor();
        List<Course> courses = courseRepository.findCoursesByMentor(mentor);

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
    public CourseListResponse findCoursesByStatus(CourseStatus status) {
        return new CourseListResponse(courseRepository
                .findCoursesByStatus(status)
                .stream()
                .map(courseMapper::mapToCourseResponse)
                .toList());

    }

    @Override
    public CourseResponse createCourse(CourseRequest courseRequest, MultipartFile image) {
        Course course = courseMapper.mapToCourse(courseRequest);
        course.setImagePath(imageService.uploadFile(image));
        course.setEntrepreneur(entrepreneurService.doGetAuthenticatedEntrepreneur());
        Course savedCourse = courseRepository.save(course);
        return courseMapper.mapToCourseResponse(savedCourse);
    }

    @Override
    public CourseResponse editCourse(Long courseId, CourseRequest courseRequest) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new EntityNotFoundException(courseId, Course.class));
        validateCourseStatus(course);
        courseMapper.updateCourse(courseRequest, course);
        Course updatedCourse = courseRepository.save(course);

        return courseMapper.mapToCourseResponse(updatedCourse);
    }

    @Override
    @Transactional
    public void deleteCourse(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new EntityNotFoundException(courseId, Course.class));
        if (course.getStatus().equals(CourseStatus.NOT_FILLED_IN))
            courseRepository.delete(course);
        else changeCourseStatus(courseId, CourseStatus.INACTIVE);
    }

    @Override
    @Transactional
    public CourseResponse changeCourseStatus(Long courseId, CourseStatus courseStatus) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new EntityNotFoundException(courseId, Course.class));
        if (!courseStatus.isAllowed(course.getStatus())) {
            throw new InvalidNewCourseStatusException(course.getStatus(), courseStatus);
        }
        if (courseStatus.equals(CourseStatus.APPROVED)) {
            String paymentLinkForCourse = stripeService.createPaymentLinkForCourse(course);
            course.setPaymentLink(paymentLinkForCourse);
        }
        course.setStatus(courseStatus);
        courseRepository.save(course);

        return courseMapper.mapToCourseResponse(course);
    }

    private void validateCourseStatus(Course course) {
        CourseStatus status = course.getStatus();
        if (!status.equals(CourseStatus.NOT_FILLED_IN))
            throw new ModifyIsNotAllowedException(status);
    }
}
