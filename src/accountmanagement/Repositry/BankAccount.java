package accountmanagement.Repositry;
import accountmanagement.services.Transactions;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
public class BankAccount {
    //    private parameters for encapsulation
    private String accountNumber ;
    private String accountHolderName;
    private double balance ;
    private ArrayList<String> transactions =new ArrayList<>();
    final double fee =5 ;
    Transactions accountTrans ;
    //////////////////////////////////////////////////////////////////////////////////
    //    define a constructor
    public  BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        balance = initialBalance;
    }
    //////////////////////////////////////////////////////////////////////////////////
    //    create setter & getter method

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setTransactions(ArrayList<String> transactions) {
        this.transactions = transactions;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getBalance() {
        return getCurrencyInEGP(balance);
    }
    public  double getbalance(){
        return balance;
    }

    public List<String> getTransactions() {
        return transactions;
    }
    //////////////////////////////////////////////////////////////////////////////////
    // helper methods
    // 1 A method to check if the entered data is not less than zero
    private boolean isLessThan(double amount){
        return amount<=0;
    }
    // 2 A method used to convert the balance into EGP
    public String getCurrencyInEGP(double value) {
        NumberFormat currency =NumberFormat.getCurrencyInstance(new Locale("EN","EG"));
        return currency.format(balance);
    }
    //////////////////////////////////////////////////////////////////////////////////
    // A method used to make a deposit
    public void makeDeposit (double amount){
        double result = 0  ;
        if (isLessThan(amount)) {
            System.out.println("Failed to make the process.");
            throw new InvalidInputException("The deposit amount must be positive.");
        }
        else {
            double initialBalance = balance; // Balance before deposit
            double finalBalance = balance + amount ; // Balance after deposit

            // Update balance
            balance = finalBalance;

            // Log the transaction
            accountTrans = new Transactions(
                    LocalDateTime.now(),
                    getAccountNumber(),
                    getAccountHolderName(),
                    initialBalance, // Initial balance before transaction
                    amount,         // The amount being deposited
                    finalBalance,  // Final balance after transaction
                    "Deposit");
            transactions.add(accountTrans.toStringDeposit()); // Add the transaction details to the transaction list
        }
    }

    // A method used to make a withdrawal
    public void makeWithdraw(double amount ) {
        if (balance < amount || isLessThan(amount)){
            System.out.println("Failed to make the process .");
            throw new InvalidInputException("The with draw amount must be positive and balance is greater than withdraw amount."+ getCurrencyInEGP(balance));
        }
        else {
            double initialBalance = balance; // Balance before withdrawal
            double finalBalance = balance - (amount + fee); // Balance after withdrawal

            // Update balance
            balance = finalBalance;

            // Log the transaction
            accountTrans = new Transactions(
                    LocalDateTime.now(),
                    getAccountNumber(),
                    getAccountHolderName(),
                    initialBalance, // Initial balance before transaction
                    amount,        // The amount that being withdrawn
                    finalBalance,  // Final balance after transaction
                    "Withdraw"
            );
            transactions.add(accountTrans.toStringWithdraw()); // Add the transaction details to the transaction list
        }
    }
    public void viewTransactionHistory(){
        for (String transaction : transactions) {
            System.out.println(transaction); //View the transaction history
        }
    }
    public StringBuilder SaveTransaction(){
        StringBuilder transactionsss = new StringBuilder();
        for (String transaction : transactions) {
            transactionsss.append(transaction).append("\n");
        }
        return transactionsss ;
    }

    @Override
    public String toString() {
        return "BankAccount{" +"\n"+
                  "accountNumber='" + accountNumber + '\'' +"\n"+
                ", accountHolderName='" + accountHolderName + '\'' +"\n"+
                ", balance=" + getCurrencyInEGP(balance)  +"\n"+
                ", transactions=" + transactions +"\n"+
                '}';
    }

}
