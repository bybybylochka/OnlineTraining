package by.bsuir.onlinetraining.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class TestCheckRequest {
    private Long studentId;
    private Long testId;
    private Map<Long, Integer> answers;
}
