package accountmanagement.main;

import accountmanagement.Repositry.BankAccount;
import accountmanagement.menu.menu;
import accountmanagement.services.AccountsServices;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankAccount user = null;
        while (true) {
            menu.Menu();
            Scanner scanner = new Scanner(System.in);
            int method = scanner.nextInt();
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
                case 3 : // In this case we make a withdraw
                    System.out.print("Please enter the amount of the Withdraw :");
                    double withdrawAmount = scanner.nextDouble();
                    user.makeWithdraw(withdrawAmount);
                    System.out.println("Withdraw done successfully . ");
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
                default:
                    throw new IllegalStateException("Unexpected value: " + method);
            }
        }
        }
    }
