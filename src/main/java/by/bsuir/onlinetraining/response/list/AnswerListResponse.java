package by.bsuir.onlinetraining.response.list;

import by.bsuir.onlinetraining.response.AnswerResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AnswerListResponse {
    private List<AnswerResponse> answers;
}
