package org.example;

// metody default i static nie licza sie do limitu
@FunctionalInterface // dokladnie jedna metoda abstrakcyjna
public interface InterestPolicy {
    double calculate(double balance);

    default InterestPolicy and(InterestPolicy other) {
        return p -> other.calculate(100);
    }

    static InterestPolicy always100 () {
        return p -> 100;
    }
}
