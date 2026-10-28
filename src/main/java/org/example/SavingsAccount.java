package org.example;

public class SavingsAccount extends BankAccount {

    private final double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);

        if (interestRate < 0) {
            throw new IllegalArgumentException("Interest rate >= 0");
        }

        this.interestRate = interestRate;
    }

    public void addInterest() {
        deposit(getBalance() * interestRate);
    }

    @Override
    public String getAccountType() {
        return "oszczędnościowe";
    }

    @Override
    public double getMonthlyCost() {
        return 0.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " oszczędnościowe";
    }


//    @Override
//    public final String formatBalance() {
//        return "balance";
//    }
}
