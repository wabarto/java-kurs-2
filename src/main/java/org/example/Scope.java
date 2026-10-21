package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Scope {

    private static int operationCount = 0; // POLE KLASY - widoczne w calej klasie

    public static void methodA() {
        int local = 10; // tylko w methodA, zmienna lokalna
        operationCount++;
        System.out.println(local);
    }


    public static void methodB() {
//        System.out.println(local);
        System.out.println(operationCount);

        for (int i = 0; i < 10; i++) {
            int block = 0; // zmienna blokowa
        }

//        System.out.println(block);
//        System.out.println(i);
    }

    public static void increase(int number) {
        number = number + 100;
    }

    public static void zeroFirst(int[] array) {
        array[0] = 0;
    }

    public static void replace(int[] array) {
        array = new int[]{9, 9, 9};
    }

    public static void main(String[] args) {
        int x = 5;
        increase(x);
        System.out.println(x);


        int[] numbers = {1, 2, 3};
        zeroFirst(numbers);
        System.out.println(numbers[0]);

        replace(numbers);
        System.out.println(Arrays.toString(numbers));
        factorial(4);
        System.out.println(power(2, -3));

        final List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");

//        list = new ArrayList<>();  - error
    }


    public static String formatAmount(int cents) {
        return String.format("%d, %02d zł", cents / 100, Math.abs(cents % 100));
    }

    public static String formatAmount(int cents, String currency) {
        return String.format("%d, %02d %s", cents / 100, Math.abs(cents % 100), currency);
    }

    public static String formatAmount(int cents, boolean withSign) {
        String sign = withSign && cents > 0 ? "+" : "";
        return sign + formatAmount(cents);
    }

    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }

        if (n <= 1) {
            return 1;  // warunek bazowy
        }

        return n * factorial(n - 1); // krok rekurencyjny
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    // gcd(48, 18) -> gcd(18, 12) -> gcd(12, 6) -> gcd(6, 0) -> 6

    // x^8 -> (x^4)^2, a x^4 -> (x2)^2

    public static double power(double base, int exp) {
        if (exp == 0) {
            return 1;
        }

        if (exp < 0) {
            return 1.0 / power(base, -exp);
        }

        if (exp % 2 == 0) {
            double half = power(base, exp / 2);
            return half * half;
        }

        return base * power(base, exp - 1);
    }

}
