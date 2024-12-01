package accountmanagement.services;
import java.time.LocalDateTime;

public class Transactions implements TransactionsInter {
    //    private parameters for encapsulation
    private LocalDateTime transactionDate;
    private String userID;
    private String userName;
    private double initialAmount; // Balance before the transaction
    private double finalAmount;   // Balance after the transaction
    private String transactionType;

    // Constructor
    public Transactions(LocalDateTime transactionDate, String userID, String userName, double initialAmount, double finalAmount, String transactionType) {
        this.transactionDate = transactionDate;
        this.userID = userID;
        this.userName = userName;
        this.initialAmount = initialAmount;
        this.finalAmount = finalAmount;
        this.transactionType = transactionType;
    }
    //////////////////////////////////////////////////////////////////////////////////
    //    create setter & getter method
    @Override
    public String toStringDeposit() {
        return "Transactions{" +
                "transactionDate=" + transactionDate +
                ", userID='" + userID + '\'' +
                ", userName='" + userName + '\'' +
                ", Deposit=" + initialAmount +
                ", Balance=" + finalAmount +
                ", Transaction type='" + transactionType + '\'' +
                '}';
    }
    @Override
    public String toStringWithdraw() {
        return "Transactions{" +
                "transactionDate=" + transactionDate +
                ", userID='" + userID + '\'' +
                ", userName='" + userName + '\'' +
                ", Withdraw='" + initialAmount + '\'' +
                ", balance='" + finalAmount + '\'' + '\''+ ", fee = '" + "5 "+ '\''+", Transaction type : " + transactionType + '\''+
                '}';
    }
}
