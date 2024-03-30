package by.bsuir.onlinetraining.controllers;

import by.bsuir.onlinetraining.models.enums.Category;
import by.bsuir.onlinetraining.models.enums.CourseStatus;
import by.bsuir.onlinetraining.request.CourseRequest;
import by.bsuir.onlinetraining.response.CourseResponse;
import by.bsuir.onlinetraining.response.list.CourseListResponse;
import by.bsuir.onlinetraining.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/{courseId}")
    public CourseResponse findCourseById(@PathVariable Long courseId) {
        return courseService.findCourseById(courseId);
    }

    @GetMapping
    public CourseListResponse findAllCourses() {
        return courseService.findAllCourses();
    }

    @GetMapping("/entrepreneur/{entrepreneurId}")
    public CourseListResponse findCoursesByEntrepreneur(@PathVariable Long entrepreneurId) {
        return courseService.findCoursesByEntrepreneur(entrepreneurId);
    }

    @GetMapping("/category/{category}")
    public CourseListResponse findCoursesByCategory(@PathVariable Category category) {
        return courseService.findCoursesByCategory(category);
    }

    @GetMapping("/status/{status}")
    public CourseListResponse findCoursesByStatus(@PathVariable CourseStatus status) {
        return courseService.findCoursesByStatus(status);
    }

    @PostMapping
    public CourseResponse createCourse(@RequestBody CourseRequest courseRequest) {
        return courseService.createCourse(courseRequest);
    }

    @PutMapping("/{courseId}")
    public CourseResponse editCourse(@PathVariable Long courseId, @RequestBody CourseRequest courseRequest) {
        return courseService.editCourse(courseId, courseRequest);
    }

    @DeleteMapping("/{courseId}")
    public void deleteCourse(@PathVariable Long courseId) {
        courseService.deleteCourse(courseId);
    }

    @PutMapping("/status/{courseId}")
    public CourseResponse changeCourseStatus(@PathVariable Long courseId, @RequestParam CourseStatus courseStatus) {
        return courseService.changeCourseStatus(courseId, courseStatus);
    }
}
