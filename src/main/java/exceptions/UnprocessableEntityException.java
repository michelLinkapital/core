package exceptions;

import enums.FieldErrorResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static enums.FieldErrorResponse.ERROR;

@Getter
@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocessableEntityException extends Exception {

    private static final long serialVersionUID = 1L;
    private final FieldErrorResponse field;

    public UnprocessableEntityException(String message) {
        super(message);
        this.field = ERROR;
    }

    public UnprocessableEntityException(String message, FieldErrorResponse field) {
        super(message);
        this.field = field;
    }

}
