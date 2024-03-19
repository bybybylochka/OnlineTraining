package by.bsuir.onlinetraining.response.list;

import by.bsuir.onlinetraining.response.MentorResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MentorListResponse {
    private List<MentorResponse> mentors;
}
