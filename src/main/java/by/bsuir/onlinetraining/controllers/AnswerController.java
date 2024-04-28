package by.bsuir.onlinetraining.controllers;

import by.bsuir.onlinetraining.request.AnswerRequest;
import by.bsuir.onlinetraining.request.CheckAnswerRequest;
import by.bsuir.onlinetraining.request.TestCheckRequest;
import by.bsuir.onlinetraining.response.AnswerResponse;
import by.bsuir.onlinetraining.response.list.AnswerListResponse;
import by.bsuir.onlinetraining.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/answers")
public class AnswerController {

    private final AnswerService answerService;
    @GetMapping("/{answerId}")
    public AnswerResponse findAnswerById(@PathVariable Long answerId) {
        return answerService.findAnswerById(answerId);
    }

    @PostMapping
    public AnswerResponse createAnswer(@RequestBody AnswerRequest answerRequest) {
        return answerService.createAnswer(answerRequest);
    }

    @PostMapping("/check")
    public AnswerResponse checkAnswer(@RequestBody CheckAnswerRequest checkAnswerRequest) {
        return answerService.checkAnswer(checkAnswerRequest);
    }

    @GetMapping("/courseUnit/{courseUnitId}")
    public AnswerListResponse findAnswersByCourseUnit(@PathVariable Long courseUnitId) {
        return answerService.findAnswersByCourseUnit(courseUnitId);
    }

    @GetMapping("/course/{courseId}")
    public AnswerListResponse findAnswersByCourse(@PathVariable Long courseId) {
        return answerService.findAnswersByCourse(courseId);
    }

    @PostMapping("/test")
    public AnswerResponse createAnswerForTest(@RequestBody TestCheckRequest request) {
        return answerService.createAnswerForTest(request);
    }

    @GetMapping("/student/{studentId}")
    public AnswerListResponse findAnswersByStudent(@PathVariable Long studentId) {
        return answerService.findAnswersByStudent(studentId);
    }
}
