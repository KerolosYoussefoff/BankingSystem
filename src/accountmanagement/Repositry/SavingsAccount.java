package accountmanagement.Repositry;

public class SavingsAccount extends BankAccount {
    // Private parameter for minimum Balance
    private final double minimumBalance ;
    public SavingsAccount(String accountNumber, String accountHolderName, double initialBalance,double minimumBalance) {
        super(accountNumber, accountHolderName, initialBalance);
        this.minimumBalance=minimumBalance;
    }
    public double getMinimumBalance() {
        return minimumBalance;
    }

}
