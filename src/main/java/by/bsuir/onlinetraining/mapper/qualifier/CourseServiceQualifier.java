package by.bsuir.onlinetraining.mapper.qualifier;

import by.bsuir.onlinetraining.exception.EntityNotFoundException;
import by.bsuir.onlinetraining.models.Course;
import by.bsuir.onlinetraining.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CourseServiceQualifier {
    private final CourseRepository courseRepository;

    @Named("findCourseById")
    public Course findCourseById(Long courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new EntityNotFoundException(courseId, Course.class));
    }
}
