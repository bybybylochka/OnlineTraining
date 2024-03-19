package by.bsuir.onlinetraining.service.impl;

import by.bsuir.onlinetraining.mapper.MentorMapper;
import by.bsuir.onlinetraining.models.Mentor;
import by.bsuir.onlinetraining.repositories.MentorRepository;
import by.bsuir.onlinetraining.service.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MentorServiceImpl implements MentorService {
    private final MentorRepository mentorRepository;
    private final MentorMapper mentorMapper;
    @Override
    public Mentor findMentorById(Long mentorId) {
        return mentorRepository.findById(mentorId)
                .orElseThrow(()->new IllegalArgumentException("Mentor was not fount by id!"));
    }
}
