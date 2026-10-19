package org.example;

import java.util.Arrays;

public class ArrayDemo {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = new int[5];
        int[] c;
        c = new int[]{1, 2, 3};


        int[] amounts = {500, 200, 100};

//        for (int i = 0; i < amounts.length; i++) {
//            amounts[i] = 0;
//        }

        System.out.println(Arrays.toString(amounts));

        for (int amount : amounts) {
            amount = 0;
        }

        System.out.println(Arrays.toString(amounts));

        // for-each tylko do odczytu

        int sum = 0;

        for (int amount : amounts) {
            sum += amount;
        }

        System.out.println(sum);

        System.out.println(amounts);

        Arrays.sort(amounts);
        System.out.println(Arrays.toString(amounts));

        Arrays.fill(amounts, 5);
        System.out.println(Arrays.toString(amounts));


//        int[] fakeCopy = amounts;
//        fakeCopy[0] = 999;
//        System.out.println(amounts[0]);

        int[] realCopy = Arrays.copyOf(amounts, amounts.length);
        realCopy[0] = 1;
        System.out.println(amounts[0]);

        int[] lastThree = Arrays.copyOfRange(amounts, 1, 3);
        System.out.println(Arrays.toString(lastThree));

        int[][] d = new int[5][3];

        int [][] m = {
                { 100, 0, 200},
                { 300, 1, 30}
        };

        // m[1][2];

        // m.length; - liczba wierszy czyli 2
        // m[1].length - liczba kolumn w wierszu drugim od zera - 3



        int [][] array = {
                { 100, 0, 200, 50},
                { 300, 1, 30, 20},
                { 25, 0, 2, 33}
        };

        System.out.println(array[2][2]);





    }
}
