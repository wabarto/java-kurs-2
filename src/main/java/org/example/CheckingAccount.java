package org.example;

import java.math.BigDecimal;

public final class CheckingAccount extends BankAccount {

    private final double monthlyFee;

    public CheckingAccount(String accountNumber, BigDecimal balance, double monthlyFee) {
        super(accountNumber, balance);
        this.monthlyFee = monthlyFee;
    }

    public void chargeMonthlyFee() {
        withdraw(BigDecimal.valueOf(monthlyFee));
    }

    @Override
    public String getAccountType() {
        return "bieżące";
    }

    @Override
    public double getMonthlyCost() {
        return monthlyFee;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + String.format(" bieżąca opłata %.2f zł/mies.", monthlyFee);
    }
}
