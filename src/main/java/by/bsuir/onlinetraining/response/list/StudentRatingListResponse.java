package by.bsuir.onlinetraining.response.list;

import by.bsuir.onlinetraining.response.StudentRatingResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class StudentRatingListResponse {
    private List<StudentRatingResponse> ratings;
}
