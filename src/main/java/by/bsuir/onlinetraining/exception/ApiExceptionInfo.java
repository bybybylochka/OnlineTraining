package by.bsuir.onlinetraining.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ApiExceptionInfo {
    private String message;
    private HttpStatus httpStatus;
    private LocalDateTime timestamp;
}
