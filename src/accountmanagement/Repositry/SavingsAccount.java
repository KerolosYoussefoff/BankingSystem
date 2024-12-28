package accountmanagement.Repositry;

public class SavingsAccount extends BankAccount {

    public SavingsAccount(String accountNumber, String accountHolderName, double initialBalance, double minimumBalance, short noMonths) {
        super(accountNumber, accountHolderName, initialBalance);
        // Private parameter for minimum Balance & number of months being hold
    }

    public double calcInterestPerMonth(double noMonths, double Balance) {
        return (noMonths * Balance * 0.2);
    }

}
