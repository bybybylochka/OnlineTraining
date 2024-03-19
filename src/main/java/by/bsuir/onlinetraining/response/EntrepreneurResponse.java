package by.bsuir.onlinetraining.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EntrepreneurResponse {
    private Long id;
    private String name;
    private String UNP;
}
