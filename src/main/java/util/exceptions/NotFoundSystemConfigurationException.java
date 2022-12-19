package util.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class NotFoundSystemConfigurationException extends SystemConfigurationException {

    public NotFoundSystemConfigurationException(String message) {
        super(message);
    }

}
