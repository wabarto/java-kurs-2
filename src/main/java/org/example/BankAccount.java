package org.example;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private final String accountNumber; // final - ustawiany tylko raz
    private double balance; // private - niedostepne z zewnatrz

    private final List<String> history = new ArrayList<>();

    public BankAccount(String accountNumber, double balance) {
        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException("Account number is required");
        }

        if (balance < 0) {
            throw new IllegalArgumentException("Balance has to be > 0");
        }

        this.accountNumber = accountNumber;
        this.balance = balance;
        history.add("OPEN");
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public List<String> getHistory() {
        return List.copyOf(history);
    }


//    public void setBalance(double balance) {
//        this.balance = balance;
//    }


    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount has to be positive");
        }

        balance += amount;
        history.add("DEPOSIT");
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount has to be positive");
        }

        if (amount > balance) {
            throw new IllegalArgumentException("balance has to be >= amount");
        }

        balance -= amount;
        history.add("WITHDRAW");
    }
}
