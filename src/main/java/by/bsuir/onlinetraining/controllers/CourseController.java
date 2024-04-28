package by.bsuir.onlinetraining.controllers;

import by.bsuir.onlinetraining.models.enums.Category;
import by.bsuir.onlinetraining.models.enums.CourseStatus;
import by.bsuir.onlinetraining.request.CourseRequest;
import by.bsuir.onlinetraining.response.CourseResponse;
import by.bsuir.onlinetraining.response.list.CourseListResponse;
import by.bsuir.onlinetraining.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @GetMapping("/entrepreneur")
    public CourseListResponse findCoursesByEntrepreneur() {
        return courseService.findCoursesByEntrepreneur();
    }

    @GetMapping("/mentor")
    public CourseListResponse findCourseMyMentor() {
        return courseService.findCoursesByMentor();
    }

    @GetMapping("/category/{category}")
    public CourseListResponse findCoursesByCategory(@PathVariable Category category) {
        return courseService.findCoursesByCategory(category);
    }

    @GetMapping("/status/{status}")
    public CourseListResponse findCoursesByStatus(@PathVariable CourseStatus status) {
        return courseService.findCoursesByStatus(status);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public CourseResponse createCourse(CourseRequest request, @RequestParam MultipartFile image) {
        return courseService.createCourse(request, image);
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
