package by.bsuir.onlinetraining.service;

import by.bsuir.onlinetraining.request.EntrepreneurRegistrationRequest;
import by.bsuir.onlinetraining.request.MentorRegistrationRequest;
import by.bsuir.onlinetraining.request.StudentRegistrationRequest;
import by.bsuir.onlinetraining.response.AuthenticationResponse;

public interface RegistrationService {
    AuthenticationResponse register(StudentRegistrationRequest registrationRequest);

    AuthenticationResponse register(EntrepreneurRegistrationRequest registrationRequest);

    AuthenticationResponse register(MentorRegistrationRequest registrationRequest);
}
