package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Demo {
    public static void main(String[] args) {
        BankAccount account1 = new SavingsAccount("PL01", 1000, 0.5);
        BankAccount account2 = new SavingsAccount("PL01", 1000, 0.3);
        account1.deposit(100);

        account1.withdraw(200);

        System.out.println(account1.getHistory());

//        account.withdraw(5000);

        account1.getHistory().clear();

        System.out.println(account1.getHistory());

//        BankAccount c = BankAccount.open(5000);
//
//        c.depositAll();
//        c.depositAll(1);
//        c.depositAll(100, 200, 300);

//        System.out.println(c);

        System.out.println(account1.equals(account2));
        System.out.println(account1 == account2);

        System.out.println(account1.getClass().getSimpleName());

        List<BankAccount> accounts = List.of(
                new SavingsAccount("Pl02", 2000, 0.3),
                new CheckingAccount("PL03", 3000, 5.0)
        );


        for (BankAccount account : accounts) {
            System.out.println(account.getDescription());
        }

        double sum = 0;

        for (BankAccount account : accounts) {
            sum += account.getBalance();
        }

        System.out.println(sum);

        BankAccount k = new SavingsAccount("PL04", 1000, 0.4);


        // k.addInterest();

        System.out.println(k.getDescription());

        TransactionHistory history = new TransactionHistory();
        history.record("1");

//        history.remove(0);

       // downcasting - rzutowanie w dol hierarchii
        BankAccount account4 = new CheckingAccount("PL01", 1000, 0.5);
        BankAccount account3 = new SavingsAccount("PL01", 1000, 0.5);
        if (account3 instanceof SavingsAccount s) { // nowsza konstrukcja
            s.addInterest();
        }
//
//        SavingsAccount s = (SavingsAccount) account4; // po staremu - ClassCastException

        // lambda
        // (parametry) -> ciało
        InterestPolicy nothing = balance -> 0;
        InterestPolicy standard = balance -> balance * 0.3;

        System.out.println(nothing.calculate(1000));
        System.out.println(standard.calculate(1000));

        // dependency injection
        new TransferService(new SmsNotifier("+481212121")).transfer(account1, account2, 100);
        new TransferService(new EmailNotifier("test@gmail.com")).transfer(account1, account2, 50);

        List accounts1 = new ArrayList();
        accounts1.add(new SavingsAccount("PL02", 1000, 0.3));
        accounts1.add("PL02");

        BankAccount a1 = (BankAccount) accounts1.get(0);
//        BankAccount b1 = (BankAccount) accounts1.get(1);

        List<BankAccount> accounts2 = new ArrayList<>();
        accounts2.add(new SavingsAccount("PL02", 1000, 0.3));
//        accounts2.add("PL02");

        accounts2.get(0);


        Box<String> boxText = new Box<>("Hello");
        String text = boxText.getContent();
        System.out.println(text);

        Box<BankAccount> boxAccount = new Box<>(new SavingsAccount("PL01", 1000, 0.3));
        System.out.println(boxAccount.getContent());

        printAll(List.of("PL01", "PL02"));
        printAll(List.of(1, 2, 3));
        printAll(accounts2);

        System.out.println(findMax(List.of(3, 17, 18)));
        System.out.println(findMax(List.of("PL02", "PL01")));

//        System.out.println(findMax(accounts2));

        List<SavingsAccount> savings = List.of(new SavingsAccount("PL01", 1000, 0.3));
        // account2 - List<BankAccount>
        // List<? extends BankAccount> - lista czegos co jest kontem - mozna czytac jako BankAccount, ale nie mozna nic dodac
        // List<? super SavingAccount> - lista konta oszczednosciowego lub jego nadtypu (BankAccount, Object) - mozna dodawac, czytac jako Object


        sumBalance(savings);

        openAccount(savings);
    }

    static double sumBalance(List<? extends BankAccount> accounts) {
        double sum = 0;
        for (BankAccount account : accounts) {
            sum += account.getBalance();
        }

        return sum;
    }

    static void openAccount(List<? super SavingsAccount> list) {
        list.add(new SavingsAccount("PL10", 1000, 0.3));
    }
    public static <T extends Comparable<T>> T findMax(List<T> list) {
        T max = list.get(0);
        for (T item : list) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }



    public static <T> void printAll(List<T> list) {
        for (T element : list) {
            System.out.println(element);
        }
    }
}
