package accountmanagement.main;

import accountmanagement.Repositry.BankAccount;
import accountmanagement.Repositry.InsufficientFundsException;
import accountmanagement.Repositry.InvalidInputException;
import accountmanagement.Repositry.SavingsAccount;
import accountmanagement.menu.menu;
import accountmanagement.services.AccountsServices;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankAccount user = null;
        SavingsAccount user1 = null;
        boolean value = true ;
        while (value) {
            menu.Menu();
            Scanner scanner = new Scanner(System.in);
            int method = scanner.nextInt();
            scanner.nextLine();
            switch (method) {
                case 1:   //In this case we create a new account 
                    user =  AccountsServices.createAccount(scanner);
                    System.out.println("Account created successfully ");
                    // CREATED THE USER WITH HIS DATA
                    break;
                case 2 : // In this case we make a deposit
                    System.out.print("Please enter the amount of the deposit :");
                    double depositAmount = scanner.nextDouble();
                    user.makeDeposit(depositAmount);
                    System.out.println("Deposit done successfully . ");
                    break;
                case 3 : // In this case we make a withdrawal
                    System.out.print("Please enter the amount of the Withdraw :");
                    extracted(scanner, user);
                    break;
                case 4 : // In this case we check the balance
                    System.out.println("Account balance is : " + user.getBalance());
                    break;
                case 5 :  // In this case we show the transaction history
                        user.viewTransactionHistory();
                    break;
                case 6 : //In this case  the user show his account details
                    String details = user.toString();
                    System.out.println(details);
                    break;
                case 7 : // Create saving account
                     user1 = AccountsServices.createSavingAccount(user.getAccountHolderName(), user.getAccountNumber(), user.getbalance(), 12000);
                     break;
                case 8 :
                    value = isValue(user);
                    break;
                default:
                    throw new InvalidInputException("Unexpected value for Method : " + method);
            }
        }
        }

    private static boolean isValue(BankAccount user) {
        boolean value;
        try (FileWriter file = new FileWriter("account_transaction.txt")) {
            StringBuilder transactionsData = user.SaveTransaction();
            file.write(String.valueOf(transactionsData).toString());
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while writing to the file" + e.getMessage());
        }
        value=false;
        System.out.println("Thank you for banking with us");
        return value;
    }

    private static void extracted(Scanner scanner, BankAccount user) {
        double withdrawAmount = scanner.nextDouble();
        if (withdrawAmount <= user.getbalance()) {
            user.makeWithdraw(withdrawAmount);
            System.out.println("Withdraw done successfully . ");
        }
        else {
            System.out.println("The account balance is not enough");
            throw new InsufficientFundsException("Value exceeds the maximum allowed limit of " + user.getBalance());
        }
    }
}
