package by.bsuir.onlinetraining.controllers;

import by.bsuir.onlinetraining.response.list.MentorListResponse;
import by.bsuir.onlinetraining.service.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mentors")
public class MentorController {
    private final MentorService mentorService;

    @GetMapping
    public MentorListResponse findAllMentors() {
        return mentorService.findAllMentors();
    }
}
