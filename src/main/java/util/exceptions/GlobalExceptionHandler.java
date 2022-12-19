package util.exceptions;

import com.linkapital.core.util.enums.FieldErrorResponse;
import feign.FeignException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Optional;

import static com.linkapital.core.configuration.context.MessageContextHolder.msg;
import static com.linkapital.core.util.enums.FieldErrorResponse.EMAIL;
import static com.linkapital.core.util.enums.FieldErrorResponse.ERROR;
import static com.linkapital.core.util.enums.FieldErrorResponse.PASSWORD;
import static com.linkapital.core.util.enums.FieldErrorResponse.REFRESH_TOKEN;
import static com.linkapital.core.util.enums.FieldErrorResponse.TOKEN;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.SERVICE_UNAVAILABLE;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;
import static org.springframework.util.StringUtils.hasText;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> exceptionHandler(Exception ex, WebRequest req) {
        return castException(ex, req);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundExceptionHandler(ResourceNotFoundException ex, WebRequest req) {
        return new ResponseEntity<>(buildErrorDetail(getExceptionMessage(ex), req.getDescription(false),
                ex.getField()), NOT_FOUND);
    }

    @ExceptionHandler(ResourceAlreadyExistException.class)
    public ResponseEntity<?> resourceAlreadyExistExceptionHandler(ResourceAlreadyExistException ex, WebRequest req) {
        return new ResponseEntity<>(buildErrorDetail(getExceptionMessage(ex), req.getDescription(false),
                ERROR), CONFLICT);
    }

    @ExceptionHandler(UnprocessableEntityException.class)
    public ResponseEntity<?> unprocessableEntityExceptionHandler(UnprocessableEntityException ex, WebRequest req) {
        return new ResponseEntity<>(buildErrorDetail(getExceptionMessage(ex), req.getDescription(false),
                ex.getField()), UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<?> feignExceptionHandler(FeignException ex, WebRequest req) {
        return new ResponseEntity<>(buildErrorDetail(getExceptionMessage(ex), req.getDescription(false),
                ERROR), SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<?> httpClientErrorExceptionHandler(HttpClientErrorException ex, WebRequest req) {
        return switch (ex.getRawStatusCode()) {
            case 400 -> new ResponseEntity<>(buildErrorDetail(getExceptionMessage(ex),
                    req.getDescription(false), ERROR), BAD_REQUEST);
            case 401 -> new ResponseEntity<>(buildErrorDetail(msg("exception.invalid.password"),
                    req.getDescription(false), PASSWORD), UNAUTHORIZED);
            default -> new ResponseEntity<>(buildErrorDetail(msg("exception.user.not.found"),
                    req.getDescription(false), EMAIL), NOT_FOUND);
        };
    }

    @ExceptionHandler(InvalidJwtAuthenticationException.class)
    public ResponseEntity<?> invalidJwtAuthenticationExceptionHandler(InvalidJwtAuthenticationException ex, WebRequest req) {
        return new ResponseEntity<>(buildErrorDetail(getExceptionMessage(ex), req.getDescription(false),
                TOKEN), UNAUTHORIZED);
    }

    @ExceptionHandler(InvalidRefreshTokenException.class)
    public ResponseEntity<?> invalidRefreshTokenExceptionHandler(InvalidRefreshTokenException ex, WebRequest req) {
        return new ResponseEntity<>(buildErrorDetail(getExceptionMessage(ex), req.getDescription(false),
                REFRESH_TOKEN), UNAUTHORIZED);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> constraintViolationHandler(ConstraintViolationException ex, WebRequest req) {
        var msg = ex.getConstraintViolations()
                .stream()
                .findFirst()
                .flatMap(constraintViolation -> hasText(constraintViolation.getMessageTemplate())
                        ? Optional.of(constraintViolation.getMessage())
                        : Optional.empty())
                .orElse(getExceptionMessage(ex));

        return new ResponseEntity<>(buildErrorDetail(msg, req.getDescription(false), ERROR), BAD_REQUEST);
    }

    @ExceptionHandler(SystemConfigurationException.class)
    public ResponseEntity<?> systemConfigurationExceptionHandler(SystemConfigurationException ex, WebRequest req) {
        var errorDetails = buildErrorDetail(getExceptionMessage(ex), req.getDescription(false),
                ERROR);
        return ex instanceof NotFoundSystemConfigurationException
                ? new ResponseEntity<>(errorDetails, NOT_FOUND)
                : new ResponseEntity<>(errorDetails, BAD_REQUEST);
    }

    @ExceptionHandler(LambdaException.class)
    public ResponseEntity<?> lambdaExceptionHandler(LambdaException ex, WebRequest req) {
        return castException(ex, req);
    }

    private ResponseEntity<?> castException(Exception ex, WebRequest req) {
        var cause = ex.getCause();

        if (cause instanceof ResourceNotFoundException resourceNotFoundException)
            return resourceNotFoundExceptionHandler(resourceNotFoundException, req);
        else if (cause instanceof ResourceAlreadyExistException resourceAlreadyExistException)
            return resourceAlreadyExistExceptionHandler(resourceAlreadyExistException, req);
        else if (cause instanceof UnprocessableEntityException unprocessableEntityException)
            return unprocessableEntityExceptionHandler(unprocessableEntityException, req);
        else if (cause instanceof FeignException feignException)
            return feignExceptionHandler(feignException, req);
        else if (cause instanceof HttpClientErrorException httpClientErrorException)
            return httpClientErrorExceptionHandler(httpClientErrorException, req);
        else if (cause instanceof InvalidJwtAuthenticationException invalidJwtAuthenticationException)
            return invalidJwtAuthenticationExceptionHandler(invalidJwtAuthenticationException, req);
        else if (cause instanceof InvalidRefreshTokenException invalidRefreshTokenException)
            return invalidRefreshTokenExceptionHandler(invalidRefreshTokenException, req);
        else if (cause instanceof ConstraintViolationException constraintViolationException)
            return constraintViolationHandler(constraintViolationException, req);
        else if (cause instanceof SystemConfigurationException systemConfigurationException)
            return systemConfigurationExceptionHandler(systemConfigurationException, req);

        return new ResponseEntity<>(buildErrorDetail(getExceptionMessage(ex), req.getDescription(false),
                ERROR), INTERNAL_SERVER_ERROR);
    }

    private ErrorDetails buildErrorDetail(String message, String details, FieldErrorResponse field) {
        return ErrorDetails
                .builder()
                .message(message)
                .details(details)
                .timestamp(LocalDateTime.now())
                .field(field)
                .build();
    }

    private String getExceptionMessage(@NotNull Exception ex) {
        var defaultMessage = ex.getMessage();
        return hasText(defaultMessage)
                ? defaultMessage
                : ex.getCause() == null
                        ? null
                        : ex.getCause().getMessage();
    }

}
