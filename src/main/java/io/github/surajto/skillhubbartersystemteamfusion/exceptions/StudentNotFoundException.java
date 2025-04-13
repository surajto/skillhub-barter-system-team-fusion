package io.github.surajto.skillhubbartersystemteamfusion.exceptions;
/**
 * Exception thrown when a student is not found in the database.
 * Used when searching for a product by id or name or email.
 */
public class StudentNotFoundException extends RuntimeException {

  /**
   * Creates a new StudentNotFoundException with the specified message.
   * @param message The error message explaining why the product was not found.
   */
  public StudentNotFoundException(String message) {
    super(message);
  }
}