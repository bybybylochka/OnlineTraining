package by.bsuir.onlinetraining.mapper.qualifier;

import by.bsuir.onlinetraining.models.CourseUnit;
import by.bsuir.onlinetraining.service.CourseUnitService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CourseUnitServiceQualifier {
    private final CourseUnitService courseUnitService;

    @Named("findCourseUnitById")
    public CourseUnit findCourseUnitById(Long courseUnitId) {
        return courseUnitService.findCourseUnitEntityById(courseUnitId);
    }
}
