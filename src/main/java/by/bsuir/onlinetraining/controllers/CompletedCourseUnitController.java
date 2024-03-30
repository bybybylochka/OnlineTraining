package by.bsuir.onlinetraining.controllers;

import by.bsuir.onlinetraining.request.CompletedCourseUnitRequest;
import by.bsuir.onlinetraining.request.SearchCompletedUnitsRequest;
import by.bsuir.onlinetraining.response.CompletedCourseUnitResponse;
import by.bsuir.onlinetraining.response.list.CompletedUnitListResponse;
import by.bsuir.onlinetraining.service.CompletedCourseUnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/completed-course-units")
public class CompletedCourseUnitController {

    private final CompletedCourseUnitService completedCourseUnitService;

    @PostMapping("/complete")
    public CompletedCourseUnitResponse completeCourseUnit(@RequestBody CompletedCourseUnitRequest completedCourseUnitRequest) {
        return completedCourseUnitService.completeCourseUnit(completedCourseUnitRequest);
    }

    @GetMapping("/search")
    public CompletedUnitListResponse findCompletedUnits(SearchCompletedUnitsRequest searchCompletedUnitsRequest) {
        return completedCourseUnitService.findCompletedUnits(searchCompletedUnitsRequest);
    }
}
