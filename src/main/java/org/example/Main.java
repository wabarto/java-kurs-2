package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int balance = 100_000;
        double rate = 0.03;
        boolean active = true;
        char symbol = 'z';
        long id = 3_000_000_000L;
        float number = 3.14f;


        System.out.println(0.1 + 0.2);
        System.out.println(0.1 + 0.2 == 0.3);

        System.out.println(7 / 2.0);

        int maxInt = Integer.MAX_VALUE;
        System.out.println(maxInt);
        System.out.println(maxInt + 1);


        int i = 1;

//        i++; // post: zwraca starą wartość, a potem zwiększa
//        ++i; // pre: zwiększa, a potem zwraca nową wartość
        // i--;
        // --i;

        int a = i++;

        System.out.println(a + " " + i); // 1 i 2

        i = 1;
        int b = ++i;

        System.out.println(b + " " + i); // 2 i 2

        // rzutowanie
        int count = 50;
        double d = count;       // rozszerzajace
        long l = count;

        double amount = 199.99;
        int truncated = (int) amount;

        System.out.println(truncated);

        System.out.println(Math.round(amount));

        char letter = 'A';
        System.out.println((int) letter);
        System.out.println((char) 66);


        // 00001100 1100
        // 0 * 2^0
        // 0 * 2^1
        // 1 * 2^2
        // 1 * 2^3
        // 8 + 4 = 12

        // 12
        // 12 / 2 = 6 reszta 0
        // 6 / 2 = 3 reszta 0
        // 3 / 2 = 1 reszta 1
        // 1 / 2 = 0 reszta 1


        int value = 12;
        System.out.println(Integer.toBinaryString(value)); // z dziesietnego na binarny
        System.out.println(Integer.toHexString(value)); // z dziesietnego na szesnatkowy
        System.out.println(Integer.parseInt("1100", 2)); // z binarnego na dziesietny

        System.out.println(0b1100); // 12

        System.out.println(0xFF); // 255

        System.out.println(String.format("%8s", Integer.toBinaryString(value)).replace(" ", "0"));



        }
    }