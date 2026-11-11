package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MemoryDemo {

    // wyciek pamieci
    private static final List<String> ENTRIES = new ArrayList<>();

    static void doubleIt(int amount) {
        amount = amount * 2;
    }

    static void depositTo(BankAccount bankAccount) {
        bankAccount.deposit(new BigDecimal("1000"));
    }

    static void replaceAccount(BankAccount account) {
        account = new SavingsAccount("PL01", new BigDecimal("999"), 0.03);
    }

    static BankAccount createReplacement() {
        return new SavingsAccount("PL99", new BigDecimal("9999"), 0.03);
    }

    private static void record(String operation) {
        // if (ENTRIES.size() >= MAX) ENTRIES.remove(0)
        // ENTRIES.clear()
        // log.info(operation)
        ENTRIES.add(operation);
    }

    public static void main(String[] args) {
        int amount = 100; // 1
        doubleIt(amount); // 2
        System.out.println(amount); // 3

        BankAccount account = new SavingsAccount("PL01", new BigDecimal("5000"), 0.03); // 4

        depositTo(account); // 5
        System.out.println(account.getBalance());

        replaceAccount(account);
        System.out.println(account.getBalance());

        account = createReplacement();

        System.out.println(account);


        List<BankAccount> accounts = new ArrayList<>();

        int i = 0;
//        while (true) {
//            new SavingsAccount("PL" + i, new BigDecimal("100"), 0.03);
//        }

        BankAccount old = new SavingsAccount("PL00", new BigDecimal("100"), 0.03);
        BankAccount account1 = new SavingsAccount("PL01", new BigDecimal("200"), 0.04);
        account1.deposit(new BigDecimal("200"));

        old = null;

        String a = "PL01";
        String b = "PL01";
        String c = new String("PL01");
        String prefix = "PL";
        String d = prefix + "01";

    }
}
