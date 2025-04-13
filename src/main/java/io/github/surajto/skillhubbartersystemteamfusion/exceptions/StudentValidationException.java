package io.github.surajto.skillhubbartersystemteamfusion.exceptions;
/**
 * Exception thrown when there is an issue with student validation.
 * For example, when the required fields are missing or have invalid values.
 */
public class StudentValidationException extends RuntimeException {

    /**
     * Creates a new StudentValidationException with the specified message.
     * @param message The error message explaining the validation isse.
     */
    public StudentValidationException(String message) {
        super(message);
    }
}