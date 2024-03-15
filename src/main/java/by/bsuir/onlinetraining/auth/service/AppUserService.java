package by.bsuir.onlinetraining.auth.service;


import by.bsuir.onlinetraining.models.Admin;
import by.bsuir.onlinetraining.models.Entrepreneur;
import by.bsuir.onlinetraining.models.Mentor;
import by.bsuir.onlinetraining.models.Student;
import by.bsuir.onlinetraining.models.enums.Role;
import by.bsuir.onlinetraining.repositories.AdminRepository;
import by.bsuir.onlinetraining.repositories.EntrepreneurRepository;
import by.bsuir.onlinetraining.repositories.MentorRepository;
import by.bsuir.onlinetraining.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AppUserService implements UserDetailsService {
    private final StudentRepository studentRepository;
    private final AdminRepository adminRepository;
    private final EntrepreneurRepository entrepreneurRepository;
    private final MentorRepository mentorRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Optional<? extends UserDetails>> optionals = new ArrayList<>();
        optionals.add(studentRepository.findByUsername(username));
        optionals.add(adminRepository.findByUsername(username));
        optionals.add(entrepreneurRepository.findByUsername(username));
        optionals.add(mentorRepository.findByUsername(username));

        return optionals.stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst()
                .orElse(null);
    }

    public UserDetails save(UserDetails userDetails, Role role) {
        return switch (role) {
            case STUDENT -> studentRepository.save((Student) userDetails);
            case MENTOR -> mentorRepository.save((Mentor) userDetails);
            case ENTREPRENEUR -> entrepreneurRepository.save((Entrepreneur) userDetails);
            case ADMIN -> adminRepository.save((Admin) userDetails);
        };
    }
}
