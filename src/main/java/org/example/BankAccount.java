package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// sealed - dziedziczyc moga tylko ci, ktorzy sa wymienieni po permits
public sealed abstract class BankAccount permits SavingsAccount, CheckingAccount, BusinessAccount {
    private final String accountNumber; // final - ustawiany tylko raz
    private BigDecimal balance; // private - niedostepne z zewnatrz
    private static int accountsCreated = 0; // jedno na kal
    private static final double MIN_INITIAL_BALANCE = 0; // stala
    private AccountStatus status = AccountStatus.ACTIVE;

    private final List<String> history = new ArrayList<>();

    public BankAccount(String accountNumber, BigDecimal balance) {
        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException("Account number is required");
        }

        if (balance.signum() < 0) {
            throw new IllegalArgumentException("Balance has to be > 0");
        }

        this.accountNumber = accountNumber;
        this.balance = balance;
        history.add("OPEN");
    }

    public abstract String getAccountType();

    public abstract double getMonthlyCost();


    // constructor chaining
    public BankAccount(String accountNumber) {
        this(accountNumber, BigDecimal.ZERO);
    }


    // konstruktor kopiujacy
    public BankAccount(BankAccount other) {
        this(other.accountNumber, other.balance);
        this.history.addAll(other.history);
    }


    // metoda wytworcza
//    public static BankAccount open(double initialBalance) {
//        return new BankAccount("PL01", initialBalance);
//    }

    // metoda wytworcza
//    public static BankAccount openWithBonus(double initialBalance) {
//        BankAccount account = open(initialBalance);
//        account.deposit(50);
//        return account;
//    }


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


    public void deposit(BigDecimal amount) {
        if (amount.signum() <= 0) {
            throw new IllegalArgumentException("amount has to be positive");
        }

        balance = balance.add(amount);
        history.add("DEPOSIT");
    }


    // overload - przeciazenie
    public void deposit(BigDecimal amount, String description) {
        balance = balance.add(amount);
        history.add(description);
    }


    @Audited(value = "CRITICAL", logAmount = true)
    public void withdraw(BigDecimal amount) {
        if (!status.canWithdraw()) {
            throw new IllegalStateException("You can't withdraw");
        }
        if (amount.signum() <= 0) {
            throw new IllegalArgumentException("amount has to be positive");
        }

        if (amount.compareTo(balance) > 0) {
            throw new IllegalArgumentException("balance has to be >= amount");
        }

        balance = balance.subtract(amount);
        history.add("WITHDRAW");
    }

    public static int getAccountsCreated() {
        return accountsCreated;
//        return balance;
    }

    // varargs - ostatni parametr i tylko jeden w metodzie
    public void depositAll(BigDecimal... amounts) {
        for (BigDecimal amount : amounts) {
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

    public BigDecimal getBalance() {
        return balance;
    }

    public String getDescription() {
        return String.format("%s: %.2f zł", accountNumber, balance);
    }


    // final na metodzie - nie da sie jej nadpisac
    public final String formatBalance() {
        return String.format("%,.2f PLN", balance);
    }

    public final String getMontlyStatement() {
        return String.format("%s [%s] - saldo %.2f zł, koszt miesięczny %.2f zł", accountNumber, getAccountType(), balance, getMonthlyCost());
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public AccountStatus getStatus() {
        return status;
    }


}
