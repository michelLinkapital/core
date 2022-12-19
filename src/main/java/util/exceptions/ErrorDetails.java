package util.exceptions;

import com.linkapital.core.util.enums.FieldErrorResponse;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ErrorDetails {

    private final String message;
    private final String details;
    private final LocalDateTime timestamp;
    private final FieldErrorResponse field;

    @Builder
    public ErrorDetails(String message, String details, LocalDateTime timestamp, FieldErrorResponse field) {
        this.message = message;
        this.details = details;
        this.timestamp = timestamp;
        this.field = field;
    }

}
