package accountmanagement.Repositry;

public class InvalidInputException extends RuntimeException {
  public InvalidInputException(String message) { //USED WHEN USER ENTER WRONG DATA

    super(message);
  }

}

