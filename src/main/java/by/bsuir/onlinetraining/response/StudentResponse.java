package by.bsuir.onlinetraining.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class StudentResponse {
    private Long id;
    private String fullName;
    private LocalDate dateOfBirth;
}
