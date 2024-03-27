package by.bsuir.onlinetraining.service.impl;

import by.bsuir.onlinetraining.exception.EntityNotFoundException;
import by.bsuir.onlinetraining.mapper.MentorMapper;
import by.bsuir.onlinetraining.models.Mentor;
import by.bsuir.onlinetraining.repositories.MentorRepository;
import by.bsuir.onlinetraining.response.list.MentorListResponse;
import by.bsuir.onlinetraining.service.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MentorServiceImpl implements MentorService {
    private final MentorRepository mentorRepository;
    private final MentorMapper mentorMapper;

    @Override
    public Mentor findMentorEntityById(Long mentorId) {
        return mentorRepository.findById(mentorId)
                .orElseThrow(() -> new EntityNotFoundException(mentorId, Mentor.class));
    }

    @Override
    public MentorListResponse findAllMentors() {
        return new MentorListResponse(mentorRepository.findAll()
                .stream()
                .map(mentorMapper::mapToMentorResponse)
                .toList());
    }
}
