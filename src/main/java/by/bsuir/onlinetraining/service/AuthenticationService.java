package by.bsuir.onlinetraining.service;

import by.bsuir.onlinetraining.request.UserAuthenticationRequest;
import by.bsuir.onlinetraining.request.UserValidationRequest;
import by.bsuir.onlinetraining.response.AuthenticationResponse;
import by.bsuir.onlinetraining.response.UserDetailsResponse;

public interface AuthenticationService {
    AuthenticationResponse authorize(UserAuthenticationRequest authenticationRequest);

    void logout();

    UserDetailsResponse me(UserValidationRequest request);
}
