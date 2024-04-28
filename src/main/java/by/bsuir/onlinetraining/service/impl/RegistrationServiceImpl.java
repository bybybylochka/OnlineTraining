package by.bsuir.onlinetraining.service.impl;

import by.bsuir.onlinetraining.auth.JWTUtils;
import by.bsuir.onlinetraining.auth.service.AppUserService;
import by.bsuir.onlinetraining.models.AuthorizationData;
import by.bsuir.onlinetraining.models.Entrepreneur;
import by.bsuir.onlinetraining.models.Mentor;
import by.bsuir.onlinetraining.models.Student;
import by.bsuir.onlinetraining.models.enums.Role;
import by.bsuir.onlinetraining.repositories.MentorRepository;
import by.bsuir.onlinetraining.request.EntrepreneurRegistrationRequest;
import by.bsuir.onlinetraining.request.MentorRegistrationRequest;
import by.bsuir.onlinetraining.request.StudentRegistrationRequest;
import by.bsuir.onlinetraining.response.AuthenticationResponse;
import by.bsuir.onlinetraining.service.EntrepreneurService;
import by.bsuir.onlinetraining.service.ImageService;
import by.bsuir.onlinetraining.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {
    private final AppUserService appUserService;
    private final JWTUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;
    private final EntrepreneurService entrepreneurService;
    private final ImageService imageService;

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

    public AuthenticationResponse register(MentorRegistrationRequest registrationRequest, MultipartFile image) {
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
                .addedBy(entrepreneurService.doGetAuthenticatedEntrepreneur())
                .imagePath(imageService.uploadFile(image))
                .build();
        UserDetails savedMentor = appUserService.save(mentor, Role.MENTOR);
        String token = jwtUtils.generateToken(savedMentor);
        return new AuthenticationResponse(token, Role.MENTOR.getName());
    }

//    @Override
//    public void addPhotoToMentor(Long mentorId, MultipartFile image) {
//        Mentor mentor = mentorRepository.findById(mentorId)
//                .orElseThrow(() -> new EntityNotFoundException(mentorId, Mentor.class));
//        mentor.setImagePath(imageService.uploadFile(image));
//        mentorRepository.save(mentor);
//    }
}
