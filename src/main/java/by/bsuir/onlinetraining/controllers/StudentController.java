package by.bsuir.onlinetraining.controllers;

import by.bsuir.onlinetraining.response.list.StudentListResponse;
import by.bsuir.onlinetraining.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public StudentListResponse findAllStudents() {
        return studentService.findAllStudents();
    }
}
