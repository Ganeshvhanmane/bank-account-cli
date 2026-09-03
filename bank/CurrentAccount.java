package bank;

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

    @Override
    void showAccountType() {
        System.out.println("Current Account");
    }
}


