package by.bsuir.onlinetraining.mapper;

import by.bsuir.onlinetraining.mapper.qualifier.CourseServiceQualifier;
import by.bsuir.onlinetraining.models.Lesson;
import by.bsuir.onlinetraining.request.LessonRequest;
import by.bsuir.onlinetraining.response.LessonResponse;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = CourseServiceQualifier.class)
public interface LessonMapper {
    @Mapping(target = "course", source = "courseId", qualifiedByName = "findCourseById")
    Lesson mapToLesson(LessonRequest request);

    @Mapping(target = "courseId", source = "course.id")
    LessonResponse mapToLessonResponse(Lesson lesson);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateLesson(LessonRequest request, @MappingTarget Lesson lesson);
}
