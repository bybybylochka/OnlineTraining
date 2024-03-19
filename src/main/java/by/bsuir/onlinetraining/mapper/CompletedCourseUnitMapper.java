package by.bsuir.onlinetraining.mapper;

import by.bsuir.onlinetraining.mapper.qualifier.CourseUnitServiceQualifier;
import by.bsuir.onlinetraining.mapper.qualifier.StudentServiceQualifier;
import by.bsuir.onlinetraining.models.CompletedCourseUnit;
import by.bsuir.onlinetraining.request.CompletedCourseUnitRequest;
import by.bsuir.onlinetraining.response.CompletedCourseUnitResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {StudentServiceQualifier.class, CourseUnitServiceQualifier.class}
)
public interface CompletedCourseUnitMapper {
    @Mapping(target = "student", source = "studentId", qualifiedByName = "findStudentById")
    @Mapping(target = "courseUnit", source = "courseUnitId", qualifiedByName = "findCourseUnitById")
    CompletedCourseUnit mapToCompletedCourseUnit(CompletedCourseUnitRequest request);

    @Mapping(target = "studentId", source = "completedCourseUnit.student.id")
    @Mapping(target = "courseUnitId", source = "completedCourseUnit.courseUnit.id")
    @Mapping(target = "courseUnitName", source = "completedCourseUnit.courseUnit.name")
    CompletedCourseUnitResponse mapToCompletedCourseUnitResponse(CompletedCourseUnit completedCourseUnit);
}
