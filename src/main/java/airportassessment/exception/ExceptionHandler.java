package airportassessment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<ErrorDto> noDataFound(NoDataFoundException exception) {
        return new ResponseEntity<>(ErrorDto.builder().message(exception.getMessage()).httpStatus(exception.getHttpStatus()).build(), HttpStatus.NOT_FOUND);
    }
}
