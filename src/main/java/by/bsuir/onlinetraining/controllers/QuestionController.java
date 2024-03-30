package by.bsuir.onlinetraining.controllers;

import by.bsuir.onlinetraining.request.UpdateQuestionsRequest;
import by.bsuir.onlinetraining.response.list.UpdatedQuestionsResponse;
import by.bsuir.onlinetraining.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionService questionService;

    @PutMapping("/update")
    public UpdatedQuestionsResponse updateQuestions(@RequestBody UpdateQuestionsRequest request) {
        return questionService.updateQuestions(request);
    }
}
