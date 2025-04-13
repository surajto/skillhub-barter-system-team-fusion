package io.github.surajto.skillhubbartersystemteamfusion.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

/**
 * Global exception handler for the application.
 * Provides consistent error responses across all controller methods.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles StudentNotFoundException and returns a 404 Not Found response.
     *
     * @param exception The exception that was thrown (StudentNotFoundException).
     * @return A ResponseEntity of ErrorResponse with error details.
     */
    @ExceptionHandler(value = StudentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProductNotFoundException(StudentNotFoundException exception) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now(),
                "Student Not Found",
                exception.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles StudentValidationException and returns a 400 Bad Request response.
     *
     * @param exception The exception that was thrown (StudentValidationException).
     * @return A ResponseEntity of ErrorResponse with error details.
     */
    @ExceptionHandler(value = StudentValidationException.class)
    public ResponseEntity<ErrorResponse> handleProductValidationException(StudentValidationException exception) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(),
                "Bad Request",
                exception.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * Fallback exception handler for all other exceptions.
     * @param exception The exception that was thrown.
     * @return ResponseEntity with generic error details.
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
     * Error response structure with timestamp, status, message and details.
     */
    private record ErrorResponse(int status, LocalDateTime timestamp, String message, String details) {
    }
}
