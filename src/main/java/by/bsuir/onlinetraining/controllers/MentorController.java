package by.bsuir.onlinetraining.controllers;

import by.bsuir.onlinetraining.request.EditMentorRequest;
import by.bsuir.onlinetraining.response.MentorResponse;
import by.bsuir.onlinetraining.response.list.MentorListResponse;
import by.bsuir.onlinetraining.service.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mentors")
public class MentorController {
    private final MentorService mentorService;

    @GetMapping
    public MentorListResponse findAllMentors() {
        return mentorService.findAllMentors();
    }

    @GetMapping("/entrepreneur")
    public MentorListResponse findAllMentorsByEntrepreneur() {
        return mentorService.findAllMentorsByEntrepreneur();
    }

    @GetMapping("/data")
    public MentorResponse getAuthenticatedMentor() {return mentorService.getAuthenticatedMentor(); }

    @GetMapping("/{mentorId}")
    public MentorResponse findMentorById (@PathVariable Long mentorId) {
        return mentorService.findMentorById(mentorId);
    }

    @PutMapping("/{mentorId}")
    public MentorResponse editMentor(@PathVariable Long mentorId, @RequestBody EditMentorRequest request) {
        return mentorService.editMentor(mentorId, request);
    }
}
