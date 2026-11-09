package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class NewDemo {
    public static void main(String[] args) {
        // dobrze - gdy typ widac w tej samej linijce
        // nie dla pol, parametrow, typow zwracanych, tylko dla zmiennych lokalnych
        var accounts = new ArrayList<BankAccount>();

        // źle
//        var x = repo.findById("PL01");


        // text block
        // przed
        String header = "===\n " + "123" + "\n------";

        System.out.println(header);

        // po
        String header1 = """
                ===
                 123
                ------
                """;

        System.out.println(header1);

        // sealed - typ z zamkniętą listą podtypów


        // punkt wyjscia refleksji Class<?>
        // getClass()
        // SavingsAccount.class, savingAccount.getClass()
        // getDeclaredMethods(), getDeclaredFields() -> isAnnotationPresent(), getAnnotation()




        BankAccount account = new SavingsAccount("PL01", BigDecimal.ZERO, 0.3);

        for (int i = 0; i < 10; i++) {
            account.deposit(BigDecimal.valueOf(0.10));
        }

        System.out.println(account.getBalance());
        System.out.println(account.getBalance().equals(1.0));

        // 0,333333

        // zle
        System.out.println(new BigDecimal(0.1));


        // poprawnie
        System.out.println(new BigDecimal("0.1"));
        System.out.println(BigDecimal.valueOf(0.1));

        BigDecimal a = new BigDecimal("100.50");
        BigDecimal b = new BigDecimal("30.25");

        a.add(b); // 130.75 // dodawanie
        a.subtract(b); // odejmowanie
        a.multiply(b); // mnozenie
        a.remainder(b); // reszta z dzielenia
        a.negate(); // negacja -100.5
        a.abs(); // wartosc bezwzgledna 100.5


        BigDecimal x1 = new BigDecimal("2.3449"); // 0.49
        System.out.println(x1.scale()); // liczba miejsc po przecinku


//        System.out.println(x1.setScale(2, RoundingMode.UP)); // 2.35
//        System.out.println(x1.setScale(2, RoundingMode.DOWN)); // 2.34
//        System.out.println(x1.setScale(2, RoundingMode.CEILING)); // 2.35
//        System.out.println(x1.setScale(2, RoundingMode.FLOOR)); // 2.34
//        System.out.println(x1.setScale(2, RoundingMode.HALF_UP)); // 2.34
//        System.out.println(x1.setScale(2, RoundingMode.HALF_DOWN)); // 2.34
//        System.out.println(x1.setScale(2, RoundingMode.HALF_EVEN)); // 2.34

//        BigDecimal x2 = new BigDecimal("2.3450"); // 0.50
//
//        System.out.println(x2.setScale(2, RoundingMode.UP)); // 2.35
//        System.out.println(x2.setScale(2, RoundingMode.DOWN)); // 2.34
//        System.out.println(x2.setScale(2, RoundingMode.CEILING)); // 2.35
//        System.out.println(x2.setScale(2, RoundingMode.FLOOR)); // 2.34
//        System.out.println(x2.setScale(2, RoundingMode.HALF_UP)); // 2.35
//        System.out.println(x2.setScale(2, RoundingMode.HALF_DOWN)); // 2.34
//        System.out.println(x2.setScale(2, RoundingMode.HALF_EVEN)); // 2.34
//
//        BigDecimal x3 = new BigDecimal("2.34500001"); // 0.51
//
//        System.out.println(x3.setScale(2, RoundingMode.UP)); // 2.35
//        System.out.println(x3.setScale(2, RoundingMode.DOWN)); // 2.34
//        System.out.println(x3.setScale(2, RoundingMode.CEILING)); // 2.35
//        System.out.println(x3.setScale(2, RoundingMode.FLOOR)); // 2.34
//        System.out.println(x3.setScale(2, RoundingMode.HALF_UP)); // 2.35
//        System.out.println(x3.setScale(2, RoundingMode.HALF_DOWN)); // 2.35
//        System.out.println(x3.setScale(2, RoundingMode.HALF_EVEN)); // 2.35
//
//        BigDecimal x4 = new BigDecimal("2.3499"); // 0.99
//
//        System.out.println(x4.setScale(2, RoundingMode.UP)); // 2.35
//        System.out.println(x4.setScale(2, RoundingMode.DOWN)); // 2.34
//        System.out.println(x4.setScale(2, RoundingMode.CEILING)); // 2.35
//        System.out.println(x4.setScale(2, RoundingMode.FLOOR)); // 2.34
//        System.out.println(x4.setScale(2, RoundingMode.HALF_UP)); // 2.35
//        System.out.println(x4.setScale(2, RoundingMode.HALF_DOWN)); // 2.35
//        System.out.println(x4.setScale(2, RoundingMode.HALF_EVEN)); // 2.35
//
//        BigDecimal x5 = new BigDecimal("2.3501"); // 0.01
//
//        System.out.println(x5.setScale(2, RoundingMode.UP));
//        System.out.println(x5.setScale(2, RoundingMode.DOWN)); // 3.15
//        System.out.println(x5.setScale(2, RoundingMode.CEILING)); // 3.15
//        System.out.println(x5.setScale(2, RoundingMode.FLOOR)); // 3.15
//        System.out.println(x5.setScale(2, RoundingMode.HALF_UP)); // 3.14
//        System.out.println(x5.setScale(2, RoundingMode.HALF_DOWN)); // 3.14
//        System.out.println(x5.setScale(2, RoundingMode.HALF_EVEN)); // 3.14
//
        BigDecimal x6 = new BigDecimal("2.3550"); // 0.50

        System.out.println(x6.setScale(2, RoundingMode.UP)); // 2.36
        System.out.println(x6.setScale(2, RoundingMode.DOWN)); // 2.35
        System.out.println(x6.setScale(2, RoundingMode.CEILING)); // 2.36
        System.out.println(x6.setScale(2, RoundingMode.FLOOR)); // 2.35
        System.out.println(x6.setScale(2, RoundingMode.HALF_UP)); // 2.36
        System.out.println(x6.setScale(2, RoundingMode.HALF_DOWN)); // 2.35
        System.out.println(x6.setScale(2, RoundingMode.HALF_EVEN)); // 2.36
//
//        BigDecimal x7 = new BigDecimal("2.3650"); // 0.50
//
//        System.out.println(x7.setScale(2, RoundingMode.UP));
//        System.out.println(x7.setScale(2, RoundingMode.DOWN)); // 3.15
//        System.out.println(x7.setScale(2, RoundingMode.CEILING)); // 3.15
//        System.out.println(x7.setScale(2, RoundingMode.FLOOR)); // 3.15
//        System.out.println(x7.setScale(2, RoundingMode.HALF_UP)); // 3.14
//        System.out.println(x7.setScale(2, RoundingMode.HALF_DOWN)); // 3.14
//        System.out.println(x7.setScale(2, RoundingMode.HALF_EVEN)); // 3.14
//
//
//        System.out.println(new BigDecimal("-7").signum());
//        System.out.println(BigDecimal.ZERO.signum());
//        System.out.println(new BigDecimal("7").signum());
//
//        new BigDecimal("10").divide(new BigDecimal("3"), 2, RoundingMode.HALF_UP);
//
//
//
//        BigDecimal a1 = new BigDecimal("5.0");
//        BigDecimal a2 = new BigDecimal("5.00");
//
//
//        System.out.println(a1.equals(a2));
//
//        System.out.println(a1.compareTo(a2) == 0);

        long start = System.nanoTime();
        String slow = "";
        for (int i = 0; i < 1000; i++) {
            slow += i;
        }

        long time1 = System.nanoTime() - start;
        start = System.nanoTime();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 1000; i++) {
            sb.append(i);
        }

        long time2 = System.nanoTime() - start;

        System.out.println(time1);
        System.out.println(time2);














    }
}
