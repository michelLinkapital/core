package exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class SMSException extends Exception {

    private static final long serialVersionUID = 1L;

    public SMSException(String message) {
        super(message);
    }

}
