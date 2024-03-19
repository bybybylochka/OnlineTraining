package by.bsuir.onlinetraining.mapper.qualifier;

import by.bsuir.onlinetraining.models.Course;
import by.bsuir.onlinetraining.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CourseServiceQualifier {
    private final CourseService courseService;

    @Named("findCourseById")
    public Course findCourseById(Long courseId) {
        return courseService.findCourseEntityById(courseId);
    }
}
