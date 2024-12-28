package accountmanagement.services;

import accountmanagement.Repositry.BankAccount;
import accountmanagement.Repositry.InsufficientFundsException;
import accountmanagement.Repositry.InvalidInputException;
import accountmanagement.Repositry.SavingsAccount;

import java.util.Random;
import java.util.Scanner;

public class AccountsServices {
    public static BankAccount createAccount(Scanner scanner) {
        try {
            System.out.print("Please enter your name:  ");
            String name = scanner.nextLine();
            if (name.matches(".*\\d.*")) { // Check if the user entered their name without any digits
                throw new InvalidInputException("The name cannot contain any digits.");
            } else if (name == null || name.isEmpty()) {
                throw new InvalidInputException("The name cannot be empty!");
            }

            Random rand = new Random();
            long accountNum = Math.abs(rand.nextLong() % 9999999999999999L) + 1; // Ensure positive account number

            System.out.print("Please enter your balance:  ");
            double balance = scanner.nextDouble();
            if (balance <= 0) {
                throw new InvalidInputException("The balance must be greater than 0!");
            }

            return new BankAccount(String.valueOf(accountNum), name, balance);
        } catch (InvalidInputException e) {
            System.out.println("Error during account creation: " + e.getMessage());
            throw e; // Re-throwing to propagate the exception if needed
        } catch (Exception e) {
            System.out.println("An unexpected error occurred during account creation: " + e.getMessage());
            throw e;
        }
    }

    public static SavingsAccount createSavingAccount(String accountNumber, String accountHolderName, double balance, double minimumBalance, short noMonths) {
        try {
            if (balance < minimumBalance) {
                throw new InsufficientFundsException("Balance is less than the required minimum balance.");
            }

            System.out.println("Saving account created successfully");
            return new SavingsAccount(accountNumber, accountHolderName, balance, minimumBalance, noMonths);
        } catch (InsufficientFundsException e) {
            System.out.println("Error during savings account creation: " + e.getMessage());
            throw e; // Re-throwing to propagate the exception if needed
        } catch (Exception e) {
            System.out.println("An unexpected error occurred during savings account creation: " + e.getMessage());
            throw e;
        }
    }
}