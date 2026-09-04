package bank;

import java.util.Scanner;

public class BankAccountCLI {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the bank\nChoose account type:\n1: Savings Account\n2: Current Account");
        System.out.print("Please enter your choice : ");
        int accountType = sc.nextInt();

        BankAccount b1;
        if (accountType == 1) {
            b1 = new SavingsAccount("Ganesh Vhanmane", 100000.00);
        } else if (accountType == 2) {
            b1 = new CurrentAccount("Ganesh Vhanmane", 100000.00);
        } else {
            System.out.println("Invalid account type.");

            sc.close();
            return;
        }

        b1.operations(sc);
        sc.close();
    }
}
