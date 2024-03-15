package by.bsuir.onlinetraining.controllers;

import by.bsuir.onlinetraining.request.EntrepreneurRegistrationRequest;
import by.bsuir.onlinetraining.request.StudentRegistrationRequest;
import by.bsuir.onlinetraining.response.AuthenticationResponse;
import by.bsuir.onlinetraining.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
