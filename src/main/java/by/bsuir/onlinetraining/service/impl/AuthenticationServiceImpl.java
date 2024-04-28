package by.bsuir.onlinetraining.service.impl;

import by.bsuir.onlinetraining.auth.JWTUtils;
import by.bsuir.onlinetraining.auth.service.AppUserService;
import by.bsuir.onlinetraining.request.UserAuthenticationRequest;
import by.bsuir.onlinetraining.request.UserValidationRequest;
import by.bsuir.onlinetraining.response.AuthenticationResponse;
import by.bsuir.onlinetraining.response.UserDetailsResponse;
import by.bsuir.onlinetraining.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final AppUserService appUserService;
    private final JWTUtils jwtUtils;

    public AuthenticationResponse authorize(UserAuthenticationRequest authenticationRequest) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                authenticationRequest.getLogin(), authenticationRequest.getPassword()
        );
        authenticationManager.authenticate(authenticationToken);
        UserDetails user = appUserService.loadUserByUsername(authenticationRequest.getLogin());
        String token = jwtUtils.generateToken(user);
        GrantedAuthority grantedAuthority = user.getAuthorities().stream().findFirst().orElseThrow();
        String role = grantedAuthority.getAuthority();
        return new AuthenticationResponse(token, role);
    }

    public void logout() {
        SecurityContextHolder.getContext().setAuthentication(null);
    }

    @Override
    public UserDetailsResponse me(UserValidationRequest request) {
        String token = request.getToken();
        try {
            String username = jwtUtils.extractUsername(token);
            UserDetails userDetails = appUserService.loadUserByUsername(username);
            if (!jwtUtils.isTokenExpired(token) && userDetails != null) {
                log.info("returned user details for role {}", extractRole(userDetails));
                return new UserDetailsResponse(true, extractRole(userDetails));
            } else {
                log.error("returned empty user details!");
                return new UserDetailsResponse(false, null);
            }
        } catch (Exception e) {
            log.error("returned empty user details!");
            return new UserDetailsResponse(false, null);
        }
    }

    private String extractRole(UserDetails userDetails) {
        return userDetails.getAuthorities()
                .stream()
                .findFirst()
                .map(GrantedAuthority::getAuthority)
                .orElseThrow();
    }
}
