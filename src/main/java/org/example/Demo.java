package org.example;

public class Demo {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("PL01", 1000);
        BankAccount account2 = new BankAccount("PL01", 1000);
        account1.deposit(100);

        account1.withdraw(200);

        System.out.println(account1.getHistory());

//        account.withdraw(5000);

        account1.getHistory().clear();

        System.out.println(account1.getHistory());

        BankAccount c = BankAccount.open(5000);

        c.depositAll();
        c.depositAll(1);
        c.depositAll(100, 200, 300);

        System.out.println(c);

        System.out.println(account1.equals(account2));
        System.out.println(account1 == account2);

        System.out.println(account1.getClass().getSimpleName());



    }
}
