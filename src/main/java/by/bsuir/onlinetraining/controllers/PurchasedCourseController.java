package by.bsuir.onlinetraining.controllers;

import by.bsuir.onlinetraining.request.PurchasedCourseRequest;
import by.bsuir.onlinetraining.response.PurchasedCourseResponse;
import by.bsuir.onlinetraining.response.list.PurchasedCourseListResponse;
import by.bsuir.onlinetraining.service.PurchasedCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/purchased-courses")
public class PurchasedCourseController {

    private final PurchasedCourseService purchasedCourseService;

    @GetMapping("/{courseId}")
    public PurchasedCourseResponse findCourseById(@PathVariable Long courseId) {
        return purchasedCourseService.findCourseById(courseId);
    }

    @GetMapping("/student/{studentId}")
    public PurchasedCourseListResponse findCoursesByStudent(@PathVariable Long studentId) {
        return purchasedCourseService.findCoursesByStudent(studentId);
    }

    @GetMapping("/course/{courseId}")
    public PurchasedCourseListResponse findCoursesByCourse(@PathVariable Long courseId) {
        return purchasedCourseService.findCoursesByCourse(courseId);
    }

    @PostMapping
    public PurchasedCourseResponse purchaseCourse(@RequestBody PurchasedCourseRequest courseRequest) {
        return purchasedCourseService.purchaseCourse(courseRequest);
    }
}
