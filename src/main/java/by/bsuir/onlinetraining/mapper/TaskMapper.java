package by.bsuir.onlinetraining.mapper;

import by.bsuir.onlinetraining.mapper.qualifier.CourseServiceQualifier;
import by.bsuir.onlinetraining.models.Task;
import by.bsuir.onlinetraining.request.TaskRequest;
import by.bsuir.onlinetraining.response.TaskResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = CourseServiceQualifier.class
)
public interface TaskMapper {
    @Mapping(target = "course", source = "courseId", qualifiedByName = "findCourseById")
    Task mapToTask(TaskRequest request);

    @Mapping(target = "courseId", source = "course.id")
    TaskResponse mapToTaskResponse(Task task);
}
