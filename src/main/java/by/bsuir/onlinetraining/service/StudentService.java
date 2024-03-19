package by.bsuir.onlinetraining.service;

import by.bsuir.onlinetraining.models.Student;
import by.bsuir.onlinetraining.response.list.StudentListResponse;

public interface StudentService {
    Student findStudentEntityById(Long studentId);

    StudentListResponse findAllStudents();
}
