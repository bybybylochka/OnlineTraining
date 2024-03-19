package by.bsuir.onlinetraining.service;

import by.bsuir.onlinetraining.models.Course;

public interface CourseService {
    Course findCourseById(Long courseId);
}
