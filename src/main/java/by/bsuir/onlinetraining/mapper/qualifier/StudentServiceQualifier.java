package by.bsuir.onlinetraining.mapper.qualifier;

import by.bsuir.onlinetraining.models.Student;
import by.bsuir.onlinetraining.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentServiceQualifier {
    private final StudentService studentService;

    @Named("findStudentById")
    public Student findStudentById(Long studentId) {
        return studentService.findStudentById(studentId);
    }

}
