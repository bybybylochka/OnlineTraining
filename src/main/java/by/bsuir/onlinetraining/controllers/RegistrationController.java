package by.bsuir.onlinetraining.controllers;

import by.bsuir.onlinetraining.request.EntrepreneurRegistrationRequest;
import by.bsuir.onlinetraining.request.MentorRegistrationRequest;
import by.bsuir.onlinetraining.request.StudentRegistrationRequest;
import by.bsuir.onlinetraining.response.AuthenticationResponse;
import by.bsuir.onlinetraining.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/registration")
public class RegistrationController {
    private final RegistrationService registrationService;

    @PostMapping("/student")
    public AuthenticationResponse register(@RequestBody StudentRegistrationRequest request) {
        return registrationService.register(request);
    }

    @PostMapping("/entrepreneur")
    public AuthenticationResponse register(@RequestBody EntrepreneurRegistrationRequest request) {
        return registrationService.register(request);
    }

    @PostMapping(value = "/mentor", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public AuthenticationResponse register(MentorRegistrationRequest request, @RequestParam MultipartFile image) {
        return registrationService.register(request, image);
    }
}
