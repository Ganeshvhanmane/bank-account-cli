import java.util.InputMismatchException;
import java.util.Scanner;

public class BankAccountCLI {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the bank\nChoose account type:\n1: Savings Account\n2: Current Account");
        System.out.print("Please enter your choice : ");
        int accountType = sc.nextInt();

        BankAccount b1;
        if (accountType == 1) {
            SavingsAccount saving = new SavingsAccount("Ganesh Vhanmane", 100000.00);
            saving.showInterest();
            b1 = saving;
        } else {
            b1 = new CurrentAccount("Ganesh Vhanmane", 100000.00);
        }

        b1.operations();
    }
}

class BankAccount {
    private final String accountHolder;
    private double balance;

    BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    double getBalance() {
        return balance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println(amount + " deposited in your account.");
        } else {
            System.out.println("Can not deposit negative amount.");
        }
    }

    void withdraw(double amount) {
        if (amount < 0) {
            System.out.println("Can not withdraw negative amount.");
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

class SavingsAccount extends BankAccount {
    private final double interestRate = 4.0; // 4% interest rate

    SavingsAccount(String accountHolder, double balance) {
        super(accountHolder, balance);
    }

    void showInterest() {
        double interest = getBalance() * interestRate / 100;
        System.out.println("if the amount " + getBalance() + " is kept for 1 year, the interest earned will be : " + interest);
    }
}

class CurrentAccount extends BankAccount {
    private final double overdraftLimit = 1000.00; // Overdraft limit of 1000

    CurrentAccount(String accountHolder, double balance) {
        super(accountHolder, balance);
    }

    @Override
  void withdraw(double amount) {
        if (amount < 0) {
            System.out.println("Can not withdraw negative amount.");
        } else if (amount > getBalance() + overdraftLimit) {
            System.out.println("Exceeds overdraft limit, cannot withdraw : " + amount);
        } else {
            debitBalance(amount);
            System.out.println(amount + " withdrawn from your account.");
        }
    }
}
