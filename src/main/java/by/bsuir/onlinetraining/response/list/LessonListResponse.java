package by.bsuir.onlinetraining.response.list;

import by.bsuir.onlinetraining.response.LessonResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class LessonListResponse {
    private List<LessonResponse> lessons;
}
