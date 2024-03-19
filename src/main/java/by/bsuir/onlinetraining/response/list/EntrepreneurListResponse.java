package by.bsuir.onlinetraining.response.list;

import by.bsuir.onlinetraining.response.EntrepreneurResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class EntrepreneurListResponse {
    private List<EntrepreneurResponse> entrepreneurs;
}
