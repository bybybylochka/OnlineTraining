package by.bsuir.onlinetraining.service;

import by.bsuir.onlinetraining.models.Mentor;
import by.bsuir.onlinetraining.response.list.MentorListResponse;

public interface MentorService {
    Mentor findMentorEntityById(Long mentorId);

    MentorListResponse findAllMentors();
}
