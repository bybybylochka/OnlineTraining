package by.bsuir.onlinetraining.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiExceptionInfo> handleEntityNotFoundException(EntityNotFoundException e) {
        ApiExceptionInfo apiExceptionInfo = new ApiExceptionInfo(e.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now());
        return new ResponseEntity<>(apiExceptionInfo, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidNewCourseStatusException.class)
    public ResponseEntity<ApiExceptionInfo> handleInvalidNewCourseStatusException(InvalidNewCourseStatusException e) {
        ApiExceptionInfo apiExceptionInfo = new ApiExceptionInfo(e.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now());
        return new ResponseEntity<>(apiExceptionInfo, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ModifyIsNotAllowedException.class)
    public ResponseEntity<ApiExceptionInfo> handleModifyIsNotAllowedException(ModifyIsNotAllowedException e) {
        ApiExceptionInfo apiExceptionInfo = new ApiExceptionInfo(e.getMessage(), HttpStatus.FORBIDDEN, LocalDateTime.now());
        return new ResponseEntity<>(apiExceptionInfo, HttpStatus.FORBIDDEN);
    }
}
