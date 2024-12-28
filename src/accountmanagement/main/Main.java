package accountmanagement.main;

import accountmanagement.Repositry.BankAccount;
import accountmanagement.Repositry.InsufficientFundsException;
import accountmanagement.Repositry.InvalidInputException;
import accountmanagement.Repositry.SavingsAccount;
import accountmanagement.menu.menu;
import accountmanagement.services.AccountsServices;

import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initialize variables for account and program state
        BankAccount user = null; // Holds the current user account
        SavingsAccount user1; // Holds the savings' account information
        boolean value = true; // Program loop control
        Scanner scanner = new Scanner(System.in); // Scanner for user input

        while (value) {
            try {
                // Display a menu to the user
                menu.Menu();

                // Read user selection
                int method = scanner.nextInt();
                scanner.nextLine(); // Clear the newline character

                // Handle user selection
                switch (method) {
                    case 1: // Create a new account
                        user = AccountsServices.createAccount(scanner);
                        System.out.println("Account created successfully ");
                        break;

                    case 2: // Make a deposit
                        if (user == null) {
                            System.out.println("No account found. Please create an account first.");
                            break;
                        }
                        System.out.print("Please enter the amount of the deposit: ");
                        depositCheck(scanner, user);
                        break;

                    case 3: // Make a withdrawal
                        if (user == null) {
                            System.out.println("No account found. Please create an account first.");
                            break;
                        }
                        System.out.print("Please enter the amount of the withdrawal: ");
                        withdrawCheck(scanner, user);
                        break;

                    case 4: // Check balance
                        if (user == null) {
                            System.out.println("No account found. Please create an account first.");
                            break;
                        }
                        System.out.println("Account balance is: " + user.getBalance());
                        break;

                    case 5: // Show transaction history
                        if (user == null) {
                            System.out.println("No account found. Please create an account first.");
                            break;
                        }
                        user.viewTransactionHistory();
                        break;

                    case 6: // Show account details
                        if (user == null) {
                            System.out.println("No account found. Please create an account first.");
                            break;
                        }
                        String details = user.toString();
                        System.out.println(details);
                        break;

                    case 7: // Create savings' account
                        if (user == null) {
                            System.out.println("No account found. Please create an account first.");
                            break;
                        }
                        System.out.print("Please enter the number of months: ");
                        try {
                            // Read a number of months and create a saving account
                            short noMonths = scanner.nextShort();
                            scanner.nextLine(); // Clear the newline character
                            user1 = AccountsServices.createSavingAccount(user.getAccountHolderName(), user.getAccountNumber(), user.getbalance(), 12000, noMonths);
                            double interest = user1.calcInterestPerMonth(user.getbalance(), noMonths);
                            System.out.println("The interest for balance is: " + interest + " ,for balance: " + user.getCurrencyInEGP(user.getbalance()) + " ,in: " + noMonths + " months with 20% of interest");
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid number of months.");
                            scanner.nextLine(); // Clear invalid input
                        }
                        break;

                    case 8: // Save transaction file
                        if (user == null) {
                            System.out.println("No account found. Please create an account first.");
                            break;
                        }
                        value = saveTransactionFile(user);
                        break;

                    default:
                        // Handle invalid menu option
                        throw new InvalidInputException("Unexpected value for method: " + method);
                }
            } catch (InvalidInputException e) {
                System.out.println("Invalid input: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            } catch (NullPointerException e) {
                System.out.println("Operation failed: Required data is missing. Please ensure you have created an account.");
            } catch (InsufficientFundsException e) {
                System.out.println("Insufficient funds: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    // Method to handle deposit
    private static void depositCheck(Scanner scanner, BankAccount user) {
        try {
            // Read deposit amount and update account balance
            double depositAmount = scanner.nextDouble();
            user.makeDeposit(depositAmount);
            System.out.println("Deposit done successfully.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid amount.");
            scanner.nextLine(); // Clear invalid input
        } catch (Exception e) {
            System.out.println("Error during deposit: " + e.getMessage());
        }
    }

    // Method to save a transaction file
    private static boolean saveTransactionFile(BankAccount user) {
        boolean value;
        try (FileWriter file = new FileWriter("account_transaction.txt")) {
            // Write transaction history to file
            StringBuilder transactionsData = user.SaveTransaction();
            file.write(transactionsData.toString());
            value = false;
            System.out.println("Thank you for banking with us");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
            value = true;
        }
        return value;
    }

    // Method to handle withdrawal
    private static void withdrawCheck(Scanner scanner, BankAccount user) {
        try {
            // Read withdrawal amount and update account balance
            double withdrawAmount = scanner.nextDouble();
            if (withdrawAmount <= user.getbalance()) {
                user.makeWithdraw(withdrawAmount);
                System.out.println("Withdrawal done successfully.");
            } else {
                System.out.println("The account balance is not enough.");
                throw new InsufficientFundsException("Value exceeds the maximum allowed limit of " + user.getBalance());
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid amount.");
            scanner.nextLine(); // Clear invalid input
        } catch (InsufficientFundsException e) {
            System.out.println("Error during withdrawal: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred during withdrawal: " + e.getMessage());
        }
    }
}
