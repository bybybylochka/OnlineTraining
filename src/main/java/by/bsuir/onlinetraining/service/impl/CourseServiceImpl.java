package by.bsuir.onlinetraining.service.impl;

import by.bsuir.onlinetraining.models.Course;
import by.bsuir.onlinetraining.repositories.CourseRepository;
import by.bsuir.onlinetraining.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Override
    public Course findCourseById(Long courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("Course wan not fount by id!"));
    }
}
