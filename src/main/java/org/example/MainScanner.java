package org.example;

import java.util.Scanner;

public class MainScanner {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int inputAmount = Integer.parseInt(scanner.nextLine());
//        String title = scanner.nextLine();
//
//        System.out.println(inputAmount);
//        System.out.println(title);
//
//        scanner.close();


        // && || !

        Scanner scanner = new Scanner(System.in);
        int amountInZloty = Integer.parseInt(scanner.nextLine());
        int amountInCents = amountInZloty * 100;
        boolean value = true;

        if (amountInZloty <= 0 || amountInZloty > 10 || !value) {
            System.out.println("Kwota musi byc dodatnia");
        } else if (amountInZloty % 10 != 0) {
            System.out.println("Bankomat wyplaca tylko wielokrotnosci 10 zl");
        } else if (amountInCents > amountInZloty) {
            System.out.println("Brak srodkow");
        } else if (amountInZloty > 5000 && amountInZloty < 7000) {
            System.out.println("Przekroczono dzienny limit");
        } else {
            System.out.println("Wyplacono " + amountInZloty);
        }



        int option = 2;
        String label;

        switch (option) {
            case 1: label = "1"; break;
            case 2: label = "2"; break;
            case 3: label = "3"; break;
            default: label = "Undefinded"; break;
        }


        String label1 = switch (option) {
            case 1 -> {
                System.out.println("1");
                yield "1";
            }
            case 2 -> "2";
            case 3 -> "3";
            default -> "undefined";
        };

        boolean active = true;
        String status = active ? doSomething() : "ZABLOKOWANE";

        int balance = 1000;


        // tak nie robimy
        String example = balance > 1000 ? "premium": (balance > 100 ? "standard" : (balance > 0 ? "basic" : "debt"));



    }

    private static String doSomething() {
        System.out.println("123");
        return "AKTYWNE";
    }
}
