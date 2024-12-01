package accountmanagement.services;
import accountmanagement.Repositry.BankAccount;

import java.util.Random;
import java.util.Scanner;

public class AccountsServices {
    public static BankAccount createAccount(Scanner scanner){
        System.out.print("Please enter your name :  ");
        String name = scanner.next();
        if(name.matches(".*\\d.*")){ // Check if the user entered his name without any characters
            throw new IllegalArgumentException("The name can not contain any digits");
        }
        scanner.nextLine();
        Random rand = new Random();
        long accountNum = rand.nextLong(9999999999999999L);
        System.out.print("please enter your balance :  ");
        double balance = scanner.nextDouble();
        scanner.nextLine();
        return new BankAccount(String.valueOf(accountNum),name,balance);
    }

}
