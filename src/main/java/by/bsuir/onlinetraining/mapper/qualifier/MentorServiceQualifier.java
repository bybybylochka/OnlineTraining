package by.bsuir.onlinetraining.mapper.qualifier;

import by.bsuir.onlinetraining.models.Mentor;
import by.bsuir.onlinetraining.service.MentorService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MentorServiceQualifier {
    private final MentorService mentorService;

    @Named("findMentorById")
    public Mentor findMentorById(Long mentorId) {
        return mentorService.findMentorById(mentorId);
    }
}
