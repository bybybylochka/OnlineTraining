package by.bsuir.onlinetraining.controllers;

import by.bsuir.onlinetraining.response.CourseUnitResponse;
import by.bsuir.onlinetraining.response.list.CourseUnitListResponse;
import by.bsuir.onlinetraining.service.CourseUnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/course-units")
public class CourseUnitController {

    private final CourseUnitService courseUnitService;

    @GetMapping("/{courseUnitId}")
    public CourseUnitResponse findCourseUnitById(@PathVariable Long courseUnitId) {
        return courseUnitService.findCourseUnitById(courseUnitId);
    }

    @GetMapping("/course/{courseId}")
    public CourseUnitListResponse findAllUnitsByCourse(@PathVariable Long courseId) {
        return courseUnitService.findAllUnitsByCourse(courseId);
    }

    @DeleteMapping("/{courseUnitId}")
    public void deleteCourseUnit(@PathVariable Long courseUnitId) {
        courseUnitService.deleteCourseUnit(courseUnitId);
    }
}
