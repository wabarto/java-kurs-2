package org.example;

import java.util.Arrays;

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

        // & - AND: bit wynikowy to 1 gdy oba bity sa 1
        // | - OR: bit wynikowy 1, gdy przynajmniej jeden jest 1
        // ^ - XOR: 1, gdy bity sa rozne
        // ~ - NOT: odwraca wszystkie bity
        // << - w lewo czyli mnozenie przez potege dwojki
        // >> - w prawo, czyli dzielenie przez potege dwojki

        int c = 12; // binarnie 1100
        int g = 10; // binarnie 1010

        System.out.println(c & g); // 1000 = 8
        System.out.println(c | g); // 1110 = 14
        System.out.println(c ^ g); // 0110 = 6
        System.out.println(~c); // 11110011 = -13        ~c = -c - 1


        System.out.println(1 << 3); // 1 * 2^3 = 8
        System.out.println(8 >> 2); // 8 / 2^2 = 2

        int n = 22;
        System.out.println((n & 1) == 0);


        // typy referencyjne


        int balanceA = 100;
        int balanceB = balanceA;
        balanceB = 999;

        System.out.println(balanceA);


        int[] historyA = {100, 200, 300};
        int[] historyB = historyA;
        historyB[0] = 999;
        System.out.println(historyA[0]);
        System.out.println(historyA == historyB);
        System.out.println(historyA);
        System.out.println(historyA.equals(historyB));

        int[] historyC = Arrays.copyOf(historyA, historyA.length);
        historyC[0] = 1;

        System.out.println(historyA[0]);


        String text = "ala";
        text.toUpperCase();
        System.out.println(text);

        String upper = text.toUpperCase();
        String upper1 = text.toUpperCase();
        System.out.println(upper == upper1);

        String aa = "Z1";
        String bb = "Z1";
        String cc = new String("Z1");
        System.out.println(aa == bb);
        System.out.println(aa.equals(bb));
        System.out.println(aa == cc);
        System.out.println(aa.equals(cc));

        String rawNumber = "   pl01 2345 6789   ";

        System.out.println(rawNumber.strip());
        System.out.println(rawNumber.isBlank());
        System.out.println(rawNumber.toUpperCase());
        System.out.println(rawNumber.toLowerCase());
        System.out.println(rawNumber.contains("2345"));
        System.out.println(rawNumber.length());
        System.out.println(rawNumber.substring(2, 6));
        System.out.println(rawNumber.replace(" ", ""));
        System.out.println(rawNumber.strip().split(" ")); // ["pl01", "2345", "6789"]
        String[] strings = rawNumber.strip().split(" ");
        System.out.println(rawNumber.equals("   PL01 2345 6789   "));

        String role = null;

        System.out.println("ADMIN".equals(role));

        }
    }