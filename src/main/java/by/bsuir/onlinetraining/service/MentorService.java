package by.bsuir.onlinetraining.service;

import by.bsuir.onlinetraining.models.Mentor;
import by.bsuir.onlinetraining.request.EditMentorRequest;
import by.bsuir.onlinetraining.response.MentorResponse;
import by.bsuir.onlinetraining.response.list.MentorListResponse;

public interface MentorService {
    Mentor findMentorEntityById(Long mentorId);

    MentorResponse findMentorById(Long mentorId);

    MentorListResponse findAllMentors();

    MentorListResponse findAllMentorsByEntrepreneur();

    MentorResponse editMentor(Long mentorId, EditMentorRequest request);

    MentorResponse getAuthenticatedMentor();

    Mentor doGetAuthenticatedMentor();
}
