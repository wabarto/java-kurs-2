package org.example;

public class TransferService {

    private final Notifier notifier;

    public TransferService(Notifier notifier) {
        this.notifier = notifier;
    }

    public void transfer(BankAccount from, BankAccount to, double amount) {
        from.withdraw(amount);
        to.deposit(amount);
        notifier.send(String.format("Przelew %.2f zł z %s na %s", amount, from.getAccountNumber(), to.getAccountNumber()));
    }
}
