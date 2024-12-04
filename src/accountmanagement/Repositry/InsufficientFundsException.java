package accountmanagement.Repositry;

public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String message) {
        // USED WHEN USER ENTER WRONG FUNDS
        super(message);
    }

}
