package org.example;

public class NoOpNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Simulate sending");
    }

    @Override
    public String getChannel() {
        return "test";
    }
}
