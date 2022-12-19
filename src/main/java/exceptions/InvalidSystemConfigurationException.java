package exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidSystemConfigurationException extends SystemConfigurationException {

    public InvalidSystemConfigurationException(String message) {
        super(message);
    }

}
