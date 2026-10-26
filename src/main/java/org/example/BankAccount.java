package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BankAccount {
    private final String accountNumber; // final - ustawiany tylko raz
    private double balance; // private - niedostepne z zewnatrz
    private static int accountsCreated = 0; // jedno na kal
    private static final double MIN_INITIAL_BALANCE = 0; // stala

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


    // constructor chaining
    public BankAccount(String accountNumber) {
        this(accountNumber, 0.0);
    }


    // konstruktor kopiujacy
    public BankAccount(BankAccount other) {
        this(other.accountNumber, other.balance);
        this.history.addAll(other.history);
    }


    // metoda wytworcza
    public static BankAccount open(double initialBalance) {
        return new BankAccount("PL01", initialBalance);
    }

    // metoda wytworcza
    public static BankAccount openWithBonus(double initialBalance) {
        BankAccount account = open(initialBalance);
        account.deposit(50);
        return account;
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public List<String> getHistory() {
//        return List.copyOf(history);
        return new ArrayList<>(history);
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

    public static int getAccountsCreated() {
        return accountsCreated;
//        return balance;
    }

    // varargs - ostatni parametr i tylko jeden w metodzie
    public void depositAll(double... amounts) {
        for (double amount : amounts) {
            deposit(amount);
        }
    }

    @Override
    public String toString() {
        return String.format("BankAccount[%s, saldo=%.2f]", accountNumber, balance);
    }

    // 1. ten sam obiekt -> true
    // 2. null albo inna klasa -> false
    // 3. rzutowanie
    // 4. porownanie pol decydujacych o tozsamosci
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BankAccount other = (BankAccount) o;
        return Objects.equals(accountNumber, other.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(accountNumber);
    }
}
