package org.example;

public class CheckingAccount extends BankAccount {

    private final double monthlyFee;

    public CheckingAccount(String accountNumber, double balance, double monthlyFee) {
        super(accountNumber, balance);
        this.monthlyFee = monthlyFee;
    }

    public void chargeMonthlyFee() {
        withdraw(monthlyFee);
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
