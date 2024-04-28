package by.bsuir.onlinetraining.service.impl;

import by.bsuir.onlinetraining.exception.EntityNotFoundException;
import by.bsuir.onlinetraining.mapper.StudentMapper;
import by.bsuir.onlinetraining.models.Student;
import by.bsuir.onlinetraining.repositories.StudentRepository;
import by.bsuir.onlinetraining.response.list.StudentListResponse;
import by.bsuir.onlinetraining.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public Student findStudentEntityById(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException(studentId, Student.class));
    }

    @Override
    public StudentListResponse findAllStudents() {
        return new StudentListResponse(studentRepository.findAll()
                .stream()
                .map(studentMapper::mapToStudentResponse)
                .toList());
    }

    @Override
    public Student getAuthenticatedStudent() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();

        return studentRepository.findByUsername(username)
                .orElseThrow();
    }
}
