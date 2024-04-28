package by.bsuir.onlinetraining.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EntrepreneurEditRequest {
    private String name;
    private String UNP;
}
