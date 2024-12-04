package accountmanagement.services;
import accountmanagement.Repositry.BankAccount;
import accountmanagement.Repositry.InsufficientFundsException;
import accountmanagement.Repositry.InvalidInputException;
import accountmanagement.Repositry.SavingsAccount;

import java.util.Random;
import java.util.Scanner;

public class AccountsServices {
    public static BankAccount createAccount(Scanner scanner){
        System.out.print("Please enter your name :  ");
        String name = scanner.nextLine();
        if(name.matches(".*\\d.*")){ // Check if the user entered his name without any characters
            throw new InvalidInputException("The name can not contain any digits");
        } else if (name==null) {
            throw new InvalidInputException("the name can not be empty !!");
        }
        Random rand = new Random();
        long accountNum = rand.nextLong(9999999999999999L);
        System.out.print("please enter your balance :  ");
        double balance = scanner.nextDouble();
        if (balance==0) {
            throw new InvalidInputException("The balance can not be 0 !!");
        }
        return new BankAccount(String.valueOf(accountNum),name,balance);
    }
    public static SavingsAccount createSavingAccount(String accountNumber, String accountHolderName, double balance, double minimumBalance){
        if (balance >= minimumBalance) {
            System.out.println("Saving account created successfully");
            return new SavingsAccount(accountNumber, accountHolderName, balance, minimumBalance);
        } else {
            throw new InsufficientFundsException("Balance is less than the required minimum balance.");
        }
    }

}
