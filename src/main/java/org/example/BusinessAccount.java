package org.example;

// non-sealed - dziedziczyc moze kazdy
public non-sealed class BusinessAccount extends BankAccount {

    public BusinessAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
    }

    @Override
    public String getAccountType() {
        return null;
    }

    @Override
    public double getMonthlyCost() {
        return 0;
    }
}
