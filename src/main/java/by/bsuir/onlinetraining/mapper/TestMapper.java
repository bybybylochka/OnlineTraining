package by.bsuir.onlinetraining.mapper;

import by.bsuir.onlinetraining.mapper.qualifier.CourseServiceQualifier;
import by.bsuir.onlinetraining.models.Test;
import by.bsuir.onlinetraining.request.TestRequest;
import by.bsuir.onlinetraining.response.TestResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {CourseServiceQualifier.class, QuestionMapper.class}
)
public interface TestMapper {
    @Mapping(target = "course", source = "courseId", qualifiedByName = "findCourseById")
    Test mapToTest(TestRequest request);

    @Mapping(target = "courseId", source = "course.id")
    TestResponse mapToTestResponse(Test test);
}
