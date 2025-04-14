package io.github.surajto.skillhubbartersystemteamfusion.Exception;

/**
 * Custom exception thrown when a student is not found in the system.
 * Typically results in a 404 NOT FOUND HTTP response, handled globally by GlobalExceptionHandler.
 */
public class StudentNotFoundException extends RuntimeException {
    /**
     * Constructs a new StudentNotFoundException with a specific error message.
     *
     * @param message detailed message explaining the cause of the exception
     */
    public StudentNotFoundException(String message) {
        super(message);
    }
}
