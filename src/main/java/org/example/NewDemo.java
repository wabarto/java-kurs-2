package org.example;

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





    }
}
