package accountmanagement.services;
import java.time.LocalDateTime;

public class Transactions implements TransactionsInter {
    //    private parameters for encapsulation
    private final LocalDateTime transactionDate;
    private final String userID;
    private final String userName;
    private final double initialAmount; // Balance before the transaction
    double withdrawOrDeposit ;   // Withdraw or deposit amount
    private final double finalAmount;   // Balance after the transaction
    private final String transactionType;

    // Constructor
    public Transactions(LocalDateTime transactionDate, String userID, String userName, double initialAmount ,double withdrawOrDeposit, double finalAmount, String transactionType) {
        this.transactionDate = transactionDate;
        this.userID = userID;
        this.userName = userName;
        this.initialAmount = initialAmount;
        this.withdrawOrDeposit=withdrawOrDeposit;
        this.finalAmount = finalAmount;
        this.transactionType = transactionType;
    }
    //////////////////////////////////////////////////////////////////////////////////
    //    create setter & getter method
    @Override
    public String toStringDeposit() {
        return "Transactions{" + "\n" +
                "transactionDate=" + transactionDate +
                ", userID='" + userID + '\'' +
                ", userName='" + userName + '\'' +
                ", Initial Balance =" + initialAmount +
                ", Deposit =" + withdrawOrDeposit +
                ", Final Balance=" + finalAmount +
                ", Transaction type='" + transactionType + '\'' +
                '}' + "\n";
    }
    @Override
    public String toStringWithdraw() {
        return "Transactions{" + "\n" +
                "transactionDate=" + transactionDate +
                ", userID='" + userID + '\'' +
                ", userName='" + userName + '\'' +
                ", Initial Balance='" + initialAmount + '\'' +
                ", Withdraw =" + withdrawOrDeposit +
                ", Final balance='" + finalAmount + '\'' + '\''+ ", fees = '" + "5 "+ '\''+", Transaction type : " + transactionType + '\''+
                '}' + "\n";
    }
}
