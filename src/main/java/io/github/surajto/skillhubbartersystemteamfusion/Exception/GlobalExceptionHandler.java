package io.github.surajto.skillhubbartersystemteamfusion.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

/**
 * Global exception handler for the application.
 * Catches and processes exceptions thrown by controller methods, providing
 * custom responses for known exception types and a general handler for unexpected errors.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles StudentNotFoundException and returns a 404 NOT FOUND response.
     *
     * @param exception the thrown StudentNotFoundException
     * @return a ResponseEntity containing an ErrorResponse with details
     */
    @ExceptionHandler(value = StudentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleStudentNotFoundException(StudentNotFoundException exception) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now(),
                "Student Not Found",
                exception.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles StudentValidationException and returns a 400 BAD REQUEST response.
     *
     * @param exception the thrown StudentValidationException
     * @return a ResponseEntity containing an ErrorResponse with details
     */
    @ExceptionHandler(value = StudentValidationException.class)
    public ResponseEntity<ErrorResponse> handleStudentValidationException(StudentValidationException exception) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(),
                "Invalid Syntax",
                exception.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles all uncaught exceptions and returns a 500 INTERNAL SERVER ERROR response.
     *
     * @param exception the unexpected exception
     * @return a ResponseEntity containing a generic ErrorResponse
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception exception) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                LocalDateTime.now(),
                "Internal Server Error",
                exception.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Record class to represent a standard error response payload.
     *
     * @param status    HTTP status code
     * @param timestamp Timestamp when the error occurred
     * @param message   Short summary of the error
     * @param details   Detailed error message
     */
    private record ErrorResponse(int status, LocalDateTime timestamp, String message, String details) {
    }
}
