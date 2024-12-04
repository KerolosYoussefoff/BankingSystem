package accountmanagement.Repositry;

public class SavingsAccount extends BankAccount {
    // Private parameter for minimum Balance & number of months being hold
    private final double minimumBalance ;
    private final short noMonths;

    public SavingsAccount(String accountNumber, String accountHolderName, double initialBalance, double minimumBalance, short noMonths) {
        super(accountNumber, accountHolderName, initialBalance);
        this.minimumBalance=minimumBalance;
        this.noMonths = noMonths;
    }
    public double getMinimumBalance() {
        return minimumBalance;
    }

    public double calcInterestPerMonth(double noMonths, double Balance) {
        return noMonths * Balance * 0.2;
    }

}
