# Java Bank Management System

## Objective
A Java-based Bank Management System demonstrating core programming concepts such as:
- Object-Oriented Programming (OOP)
- Exception Handling
- Collections Framework
- Input/Output Handling

This project serves as an assignment to practice clean coding and proper design principles.

---

## Features
1. **Account Management**  
   - Create, manage, and display account details.  
   - Fields: `accountNumber`, `accountHolderName`, `balance`, and `transactions`.  

2. **Deposits and Withdrawals**  
   - Deposit funds into an account (`deposit(double amount)`).  
   - Withdraw funds with exception handling for insufficient balance (`withdraw(double amount)`).  

3. **Transaction History**  
   - Maintain and display a record of all transactions.  

4. **Menu-Based Interface**  
   - User-friendly console menu for operations:  
     - Create Account  
     - Deposit Funds  
     - Withdraw Funds  
     - Check Balance  
     - View Transaction History
     - Create saving account 
     - Exit  // saving the transactions in file.txt
---

## Object-Oriented Design Principles
1. **Encapsulation**  
   - All fields are private with appropriate getter and setter methods.

2. **Inheritance**  
   - `BankAccount` class is extended by `SavingsAccount`, adding:  
     - Minimum balance enforcement.  
     - Overriding the `withdraw` method.  

3. **Interfaces**  
   - A `Reportable` interface for generating account summaries.

---

## Advanced Features (Optional)
1. **Interest Calculation**  
   - Calculate interest for savings accounts.  

2. **File Handling**  
   - Save transaction history to a text file.  
   - Load account details from a file.  

3. **Custom Exceptions**  
   - `InsufficientFundsException` for withdrawal errors.  
   - `InvalidInputException` for handling invalid inputs.  

---

## Project Files
### `src/`
- Contains all Java source files.

### `transactions/`
- Stores transaction history as text files.

### `output/screenshots/`
- Includes evidence of program functionality.

---

## How to Run the Project
1. **Compile** the Java files:  
   ```bash
   javac src/*.java




   Author
Kerolos Youssef
kerolosyoussefoff@gmail.com

