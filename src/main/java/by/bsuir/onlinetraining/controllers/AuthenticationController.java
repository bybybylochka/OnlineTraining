package by.bsuir.onlinetraining.controllers;

import by.bsuir.onlinetraining.request.UserAuthenticationRequest;
import by.bsuir.onlinetraining.request.UserValidationRequest;
import by.bsuir.onlinetraining.response.AuthenticationResponse;
import by.bsuir.onlinetraining.response.UserDetailsResponse;
import by.bsuir.onlinetraining.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authorization")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody UserAuthenticationRequest request) {
        return authenticationService.authorize(request);
    }

    @PostMapping("/me")
    public UserDetailsResponse me(@RequestBody UserValidationRequest request){
        return authenticationService.me(request);
    }

    @GetMapping("/logout")
    public void logout() {
        authenticationService.logout();
    }
}
