package by.bsuir.onlinetraining.mapper;

import by.bsuir.onlinetraining.mapper.qualifier.CourseUnitServiceQualifier;
import by.bsuir.onlinetraining.mapper.qualifier.StudentServiceQualifier;
import by.bsuir.onlinetraining.models.Answer;
import by.bsuir.onlinetraining.request.AnswerRequest;
import by.bsuir.onlinetraining.response.AnswerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {StudentServiceQualifier.class, CourseUnitServiceQualifier.class}
)
public interface AnswerMapper {
    @Mapping(target = "student", source = "studentId", qualifiedByName = "findStudentById")
    @Mapping(target = "courseUnit", source = "courseUnitId", qualifiedByName = "findCourseUnitById")
    Answer mapToAnswer(AnswerRequest request);

    @Mapping(target = "courseId", source = "answer.courseUnit.course.id")
    @Mapping(target = "courseName", source = "answer.courseUnit.course.name")
    @Mapping(target = "courseUnitId", source = "answer.courseUnit.id")
    @Mapping(target = "courseUnitName", source = "answer.courseUnit.name")
    @Mapping(target = "studentId", source = "answer.student.id")
    @Mapping(target = "studentFullName", source = "answer.student.fullName")
    AnswerResponse mapToAnswerResponse(Answer answer);
}
