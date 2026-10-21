package org.example;

public class Demo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("PL01", 1000);
        account.deposit(100);

        account.withdraw(200);

        System.out.println(account.getHistory());

//        account.withdraw(5000);

        account.getHistory().clear();

        System.out.println(account.getHistory());


    }
}
