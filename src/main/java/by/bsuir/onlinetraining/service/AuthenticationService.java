package by.bsuir.onlinetraining.service;

import by.bsuir.onlinetraining.request.UserAuthenticationRequest;
import by.bsuir.onlinetraining.response.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse authorize(UserAuthenticationRequest authenticationRequest);

    void logout();
}
