package org.example;

public interface Notifier {
    // abstrakcyjne
    void send(String message);
    String getChannel();

    // default
    default String describe() {
        return "Powiadomienia kanałem " + getChannel();
    }

    static Notifier silent() {
        return new NoOpNotifier();
    }

    int MAX_MESSAGE_LENGHTH = 100;
}

