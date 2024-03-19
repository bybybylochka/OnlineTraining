package by.bsuir.onlinetraining.mapper;

import by.bsuir.onlinetraining.models.Student;
import by.bsuir.onlinetraining.response.StudentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StudentMapper {
    StudentResponse mapToStudentResponse(Student student);
}
