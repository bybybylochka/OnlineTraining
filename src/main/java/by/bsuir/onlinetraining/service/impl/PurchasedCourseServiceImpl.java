package by.bsuir.onlinetraining.service.impl;

import by.bsuir.onlinetraining.exception.EntityNotFoundException;
import by.bsuir.onlinetraining.mapper.PurchasedCourseMapper;
import by.bsuir.onlinetraining.models.Course;
import by.bsuir.onlinetraining.models.PurchasedCourse;
import by.bsuir.onlinetraining.models.Student;
import by.bsuir.onlinetraining.repositories.PurchasedCourseRepository;
import by.bsuir.onlinetraining.request.PurchasedCourseRequest;
import by.bsuir.onlinetraining.response.PurchasedCourseResponse;
import by.bsuir.onlinetraining.response.list.PurchasedCourseListResponse;
import by.bsuir.onlinetraining.service.CourseService;
import by.bsuir.onlinetraining.service.PurchasedCourseService;
import by.bsuir.onlinetraining.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchasedCourseServiceImpl implements PurchasedCourseService {
    private final PurchasedCourseRepository purchasedCourseRepository;
    private final PurchasedCourseMapper purchasedCourseMapper;
    private final StudentService studentService;
    private final CourseService courseService;
    @Override
    public PurchasedCourse findCourseEntityById(Long courseId) {
        return purchasedCourseRepository.findById(courseId)
                .orElseThrow(() -> new EntityNotFoundException(courseId, PurchasedCourse.class));
    }

    @Override
    public PurchasedCourseResponse findCourseById(Long courseId) {
        return purchasedCourseRepository.findById(courseId)
                .map(purchasedCourseMapper::mapToPurchasedCourseResponse)
                .orElseThrow(() -> new EntityNotFoundException(courseId, PurchasedCourse.class));
    }

    @Override
    public PurchasedCourseListResponse findCoursesByStudent(Long studentId) {
        Student student = studentService.findStudentEntityById(studentId);
        List<PurchasedCourse> courses = purchasedCourseRepository.findPurchasedCoursesByStudent(student);

        return new PurchasedCourseListResponse(courses
                .stream()
                .map(purchasedCourseMapper::mapToPurchasedCourseResponse)
                .toList());
    }

    @Override
    public PurchasedCourseListResponse findCoursesByCourse(Long courseId) {
        Course course = courseService.findCourseEntityById(courseId);
        List<PurchasedCourse> courses = purchasedCourseRepository.findPurchasedCoursesByCourse(course);

        return new PurchasedCourseListResponse(courses
                .stream()
                .map(purchasedCourseMapper::mapToPurchasedCourseResponse)
                .toList());
    }

    @Override
    public PurchasedCourseResponse purchaseCourse(PurchasedCourseRequest courseRequest) {
        PurchasedCourse purchasedCourse = purchasedCourseMapper.mapToPurchasedCourse(courseRequest);
        PurchasedCourse savedPurchasedCourse = purchasedCourseRepository.save(purchasedCourse);

        return purchasedCourseMapper.mapToPurchasedCourseResponse(savedPurchasedCourse);
    }
}
