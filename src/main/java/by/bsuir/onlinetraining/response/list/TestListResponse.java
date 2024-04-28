package by.bsuir.onlinetraining.response.list;

import by.bsuir.onlinetraining.response.TestResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TestListResponse {
    private List<TestResponse> tests;
}
