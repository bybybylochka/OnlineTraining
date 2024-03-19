package by.bsuir.onlinetraining.mapper;

import by.bsuir.onlinetraining.mapper.qualifier.CourseServiceQualifier;
import by.bsuir.onlinetraining.models.CourseUnit;
import by.bsuir.onlinetraining.request.CourseUnitRequest;
import by.bsuir.onlinetraining.response.CourseUnitResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {CourseServiceQualifier.class}
)
public interface CourseUnitMapper {
    @Mapping(target = "course", source = "courseId", qualifiedByName = "findCourseById")
    CourseUnit mapToCourseUnit(CourseUnitRequest request);

    @Mapping(target = "courseId", source = "courseUnit.course.id")
    CourseUnitResponse mapToCourseUnitResponse(CourseUnit courseUnit);

    List<CourseUnitResponse> matToCourseUnitResponseList(List<CourseUnit> courseUnitList);
}
