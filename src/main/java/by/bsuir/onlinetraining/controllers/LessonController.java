package by.bsuir.onlinetraining.controllers;

import by.bsuir.onlinetraining.request.LessonRequest;
import by.bsuir.onlinetraining.response.LessonResponse;
import by.bsuir.onlinetraining.response.list.LessonListResponse;
import by.bsuir.onlinetraining.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lessons")
public class LessonController {

    private final LessonService lessonService;
    @PostMapping
    public LessonResponse createLesson(@RequestBody LessonRequest lessonRequest) {
        return lessonService.createLesson(lessonRequest);
    }

    @GetMapping("/course/{courseId}")
    public LessonListResponse findLessonsByCourse(@PathVariable Long courseId) {
        return lessonService.findLessonsByCourse(courseId);
    }

    @PutMapping("/{lessonId}")
    public LessonResponse editLesson(@PathVariable Long lessonId, @RequestBody LessonRequest request) {
        return lessonService.editLesson(lessonId, request);
    }
    @GetMapping("/{lessonId}")
    public LessonResponse findLessonById(@PathVariable Long lessonId) {
        return lessonService.findLessonById(lessonId);
    }


    @DeleteMapping("/{lessonId}")
    public void deleteLesson(@PathVariable Long lessonId) {
        lessonService.deleteLesson(lessonId);
    }
}
