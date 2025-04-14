package io.github.surajto.skillhubbartersystemteamfusion.Exception;

/**
 * Custom exception thrown when student validation fails,
 * such as during input validation or business rule enforcement.
 * Typically results in a 400 BAD REQUEST HTTP response, handled by GlobalExceptionHandler.
 */
public class StudentValidationException extends RuntimeException {

    /**
     * Constructs a new StudentValidationException with a specific error message.
     *
     * @param message detailed message explaining the cause of the validation failure
     */
    public StudentValidationException(String message) {
        super(message);
    }
}
