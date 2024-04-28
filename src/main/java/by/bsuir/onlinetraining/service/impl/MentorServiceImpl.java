package by.bsuir.onlinetraining.service.impl;

import by.bsuir.onlinetraining.exception.EntityNotFoundException;
import by.bsuir.onlinetraining.mapper.MentorMapper;
import by.bsuir.onlinetraining.models.Entrepreneur;
import by.bsuir.onlinetraining.models.Mentor;
import by.bsuir.onlinetraining.repositories.MentorRepository;
import by.bsuir.onlinetraining.request.EditMentorRequest;
import by.bsuir.onlinetraining.response.MentorResponse;
import by.bsuir.onlinetraining.response.list.MentorListResponse;
import by.bsuir.onlinetraining.service.EntrepreneurService;
import by.bsuir.onlinetraining.service.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MentorServiceImpl implements MentorService {
    private final MentorRepository mentorRepository;
    private final MentorMapper mentorMapper;
    private final EntrepreneurService entrepreneurService;

    @Override
    public Mentor findMentorEntityById(Long mentorId) {
        return mentorRepository.findById(mentorId)
                .orElseThrow(() -> new EntityNotFoundException(mentorId, Mentor.class));
    }

    @Override
    public MentorResponse findMentorById(Long mentorId) {
        return mentorRepository.findById(mentorId)
                .map(mentorMapper::mapToMentorResponse)
                .orElseThrow(() -> new EntityNotFoundException(mentorId, Mentor.class));
    }

    @Override
    public MentorListResponse findAllMentors() {
        return new MentorListResponse(mentorRepository.findAll()
                .stream()
                .map(mentorMapper::mapToMentorResponse)
                .toList());
    }

    @Override
    public MentorListResponse findAllMentorsByEntrepreneur() {
        Entrepreneur entrepreneur = entrepreneurService.doGetAuthenticatedEntrepreneur();
        List<Mentor> mentorList = mentorRepository.findAllByAddedBy(entrepreneur);

        return new MentorListResponse(mentorList.stream()
                .map(mentorMapper::mapToMentorResponse)
                .toList());
    }

    @Override
    public MentorResponse editMentor(Long mentorId, EditMentorRequest request) {
        Mentor mentor = findMentorEntityById(mentorId);
        mentorMapper.updateMentor(request, mentor);
        mentorRepository.save(mentor);

        return mentorMapper.mapToMentorResponse(mentor);
    }
    @Override
    public MentorResponse getAuthenticatedMentor() {
        Mentor mentor = doGetAuthenticatedMentor();

        return mentorMapper.mapToMentorResponse(mentor);
    }
    public Mentor doGetAuthenticatedMentor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();

        return mentorRepository.findByUsername(username)
                .orElseThrow();
    }
}
