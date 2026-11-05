package org.example;

import java.math.BigDecimal;

// non-sealed - dziedziczyc moze kazdy
public non-sealed class BusinessAccount extends BankAccount {

    public BusinessAccount(String accountNumber, BigDecimal balance, double interestRate) {
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
