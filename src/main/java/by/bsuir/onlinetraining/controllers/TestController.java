package by.bsuir.onlinetraining.controllers;

import by.bsuir.onlinetraining.request.TestRequest;
import by.bsuir.onlinetraining.request.UpdateTestRequest;
import by.bsuir.onlinetraining.response.TestResponse;
import by.bsuir.onlinetraining.response.list.TestListResponse;
import by.bsuir.onlinetraining.service.TestService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tests")
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/{testId}")
    public TestResponse findTestById(@PathVariable Long testId) {
        return testService.findTestById(testId);
    }

    @PostMapping
    public TestResponse createTest(@RequestBody TestRequest testRequest) {
        return testService.createTest(testRequest);
    }

    @PutMapping
    public TestResponse editTest(@RequestBody UpdateTestRequest testRequest) {
        return testService.editTest(testRequest);
    }

    @GetMapping("/course/{courseId}")
    public TestListResponse findTestsByCourse(@PathVariable Long courseId) {
        return testService.findTestsByCourse(courseId);
    }

    @DeleteMapping("/{testId}")
    public void deleteTest(@PathVariable Long testId) {
        testService.deleteTest(testId);
    }
}