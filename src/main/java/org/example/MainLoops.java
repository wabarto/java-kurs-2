package org.example;

public class MainLoops {
    public static void main(String[] args) {
        // for
        // for (inicjalizacja; warunek; krok;)

        for (int i = 0; i < 3; i++) {
            System.out.println(i + " ");
        }

        for (int i = 3; i >= 1; i--) {
            System.out.println(i + " ");
        }

        for (int i = 50; i <= 500; i += 50) {
            System.out.println(i + " ");
        }


        int balance = 0;
        while (balance > 100) {
            System.out.println("To sie nie wykona");
        }

        int attempt = 0;
        do {
            attempt++;

        } while (attempt < 3);


        int[] numbers = {500, 300, 200, 100};

        for (int element : numbers) {
            System.out.println(element);
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("start " + i);
            if (i == 3) {
//                break;
                continue;
            }

            System.out.println("end " + i);
        }


        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println(i + " " + j);
            }
        }
    }
}
