package bank;

import java.util.InputMismatchException;
import java.util.Scanner;

abstract class BankAccount {
    private final String accountHolder;
    private double balance;

    BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    abstract void showAccountType();

    double getBalance() {
        return balance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println(amount + " deposited in your account.");
        } else {
            System.out.println("Can not deposit 0 or negative amount.");
        }
    }

    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Can not withdraw 0 or negative amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance, cannot withdraw : " + amount);
        } else {
            balance = balance - amount;
            System.out.println(amount + " withdrawn from your account.");
        }
    }

    protected void debitBalance(double amount) {
        balance -= amount;
    }

    void showBalance() {

        System.out.println(accountHolder + "'s balance : " + balance);
    }

    void showInterest() {
        System.out.println("Interest calculations are not applicable for this account type.");
    }

    void operations(Scanner sc) {
        System.out.print("Welcome to your ");
        this.showAccountType();
        int choice = 0;
        while (choice != 5) {
            System.out.print("Choices of operations :\n1 : Deposit\n2 : Withdraw\n3 : Balance\n4 : Interest\n5 : Exit\nPlease choose an operation : ");
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number.");
                sc.next();
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Please enter the amount to deposit : ");
                    double depositAmount;
                    try {
                        depositAmount = sc.nextDouble();
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter a number.");
                        sc.next();
                        continue;
                    }
                    deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Please enter the amount to withdraw : ");
                    double withdrawAmount;
                    try {
                        withdrawAmount = sc.nextDouble();
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter a number.");
                        sc.next();
                        continue;
                    }
                    withdraw(withdrawAmount);
                    break;
                case 3:
                    showBalance();
                    break;
                case 4:
                    showInterest();
                    break;
                case 5:
                    System.out.println("Thank You.");
                    break;
                default:
                    System.out.println("Invalid operation.");
            }
        }
    }
}