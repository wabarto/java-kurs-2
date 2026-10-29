package org.example;

@FunctionalInterface // dokladnie jedna metoda abstrakcyjna
public interface InterestPolicy {
    double calculate(double balance);
}
