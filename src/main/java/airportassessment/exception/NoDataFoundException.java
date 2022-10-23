package airportassessment.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoDataFoundException extends RuntimeException {
    private String message;
    private HttpStatus httpStatus;
}
