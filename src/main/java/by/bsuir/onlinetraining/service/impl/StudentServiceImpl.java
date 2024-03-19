package by.bsuir.onlinetraining.service.impl;

import by.bsuir.onlinetraining.mapper.StudentMapper;
import by.bsuir.onlinetraining.models.Student;
import by.bsuir.onlinetraining.repositories.StudentRepository;
import by.bsuir.onlinetraining.response.list.StudentListResponse;
import by.bsuir.onlinetraining.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public Student findStudentEntityById(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Student was not found by id"));
    }

    @Override
    public StudentListResponse findAllStudents() {
        return null;
    }
}
