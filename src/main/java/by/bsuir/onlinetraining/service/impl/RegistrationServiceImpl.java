package by.bsuir.onlinetraining.service.impl;

import by.bsuir.onlinetraining.auth.JWTUtils;
import by.bsuir.onlinetraining.auth.service.AppUserService;
import by.bsuir.onlinetraining.models.AuthorizationData;
import by.bsuir.onlinetraining.models.Entrepreneur;
import by.bsuir.onlinetraining.models.Mentor;
import by.bsuir.onlinetraining.models.Student;
import by.bsuir.onlinetraining.models.enums.Role;
import by.bsuir.onlinetraining.request.EntrepreneurRegistrationRequest;
import by.bsuir.onlinetraining.request.MentorRegistrationRequest;
import by.bsuir.onlinetraining.request.StudentRegistrationRequest;
import by.bsuir.onlinetraining.response.AuthenticationResponse;
import by.bsuir.onlinetraining.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {
    private final AppUserService appUserService;
    private final JWTUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationResponse register(StudentRegistrationRequest registrationRequest) {
        if (appUserService.loadUserByUsername(registrationRequest.getLogin()) != null) {
            throw new IllegalArgumentException("user with this username already exists!");
        }

        AuthorizationData authData = AuthorizationData.builder()
                .login(registrationRequest.getLogin())
                .password(passwordEncoder.encode(registrationRequest.getPassword()))
                .build();
        Student student = Student.builder()
                .fullName(registrationRequest.getFullName())
                .dateOfBirth(registrationRequest.getDateOfBirth())
                .authorizationData(authData)
                .build();
        UserDetails savedStudent = appUserService.save(student, Role.STUDENT);
        String token = jwtUtils.generateToken(savedStudent);
        return new AuthenticationResponse(token, Role.STUDENT.getName());
    }

    public AuthenticationResponse register(EntrepreneurRegistrationRequest registrationRequest) {
        if (appUserService.loadUserByUsername(registrationRequest.getLogin()) != null) {
            throw new IllegalArgumentException("user with this username already exists!");
        }

        AuthorizationData authData = AuthorizationData.builder()
                .login(registrationRequest.getLogin())
                .password(passwordEncoder.encode(registrationRequest.getPassword()))
                .build();
        Entrepreneur entrepreneur = Entrepreneur.builder()
                .name(registrationRequest.getName())
                .UNP(registrationRequest.getUNP())
                .authorizationData(authData)
                .build();
        UserDetails savedEntrepreneur = appUserService.save(entrepreneur, Role.ENTREPRENEUR);
        String token = jwtUtils.generateToken(savedEntrepreneur);
        return new AuthenticationResponse(token, Role.ENTREPRENEUR.getName());
    }

    public AuthenticationResponse register(MentorRegistrationRequest registrationRequest) {
        if (appUserService.loadUserByUsername(registrationRequest.getLogin()) != null) {
            throw new IllegalArgumentException("user with this username already exists!");
        }

        AuthorizationData authData = AuthorizationData.builder()
                .login(registrationRequest.getLogin())
                .password(passwordEncoder.encode(registrationRequest.getPassword()))
                .build();
        Mentor mentor = Mentor.builder()
                .fullName(registrationRequest.getFullName())
                .characteristic(registrationRequest.getCharacteristic())
                .experience(registrationRequest.getExperience())
                .authorizationData(authData)
                .build();
        UserDetails savedMentor = appUserService.save(mentor, Role.MENTOR);
        String token = jwtUtils.generateToken(savedMentor);
        return new AuthenticationResponse(token, Role.MENTOR.getName());
    }
}
