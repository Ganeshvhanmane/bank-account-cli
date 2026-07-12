import java.util.InputMismatchException;
import java.util.Scanner;

public class BankAccountDemo {
    public static void main(String[] args) {

    BankAccount b1 = new BankAccount("Ganesh Vhanmane", 100000.00);
    b1.operations();
    }
}

class BankAccount {
    String accountHolder;
    double balance;

    BankAccount(String accountHolder,double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    void deposit(double amount) {
        if(amount > 0) {
            balance = balance + amount;
            System.out.println(amount + " deposited in your account.");
        } else {
            System.out.println("Can not deposit negative amount.");
        }
    }

    void withdraw(double amount) {
        if(amount < 0) {
            System.out.println("Can not withdraw negative amount.");
        } else if(amount > balance) {
            System.out.println("Insufficient balance, cannot withdraw : " + amount);
        } else {
            balance = balance - amount;
            System.out.println(amount + " withdrawn from your account.");
        }
    }

    void showBalance() {
        System.out.println(balance);
    }

    void operations() {
        System.out.println("Welcome to your account.");
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        while (choice != 4) {
            System.out.print("Choices of operations :\n1 : deposit\n2 : withdraw\n3 : balance\n4 : Exit\nPlease choose an operation : ");
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
                    System.out.println("Thank you.");
                    break;
                default:
                    System.out.println("Invalid operation.");
            }
        }
    }
}