package bank;

class SavingsAccount extends BankAccount {
    private final double interestRate = 4.0; // 4% interest rate

    SavingsAccount(String accountHolder, double balance) {
        super(accountHolder, balance);
    }

    void showInterest() {
        double interest = getBalance() * interestRate / 100;
        System.out.println("if the amount " + getBalance() + " is kept for 1 year, the interest earned will be : " + interest);
    }

    @Override
    void showAccountType() {
        System.out.println("Savings Account");
    }
}
