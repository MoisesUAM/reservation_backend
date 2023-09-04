package net.mcoto.app.model_response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.nio.file.AccessDeniedException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ReservationApiException.class)
    public ResponseEntity<ErrorDetails> handleReservationApiException(ReservationApiException  exception, WebRequest request) {
        ErrorDetails details = new ErrorDetails();
        details.setErrorCode(exception.getStatus().value());
        details.setErrorMessage(exception.getMessage());
        details.setDevErrorMessage(request.getDescription(false));
        details.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorDetails> handleAccessDeniedException(AccessDeniedException  exception, WebRequest request) {
        ErrorDetails details = new ErrorDetails();
        details.setErrorMessage(exception.getMessage());
        details.setDevErrorMessage(request.getDescription(false));
        details.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(details, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleException(Exception  exception, WebRequest request) {
        ErrorDetails details = new ErrorDetails();
        details.setErrorMessage(exception.getMessage());
        details.setDevErrorMessage(request.getDescription(false));
        details.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
    }

}
