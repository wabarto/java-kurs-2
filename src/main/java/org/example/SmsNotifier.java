package org.example;

public class SmsNotifier implements Notifier {
    private final String phoneNumber;

    public SmsNotifier(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void send(String message) {
        System.out.println("SMS - " + phoneNumber + " - " + message);
    }

    @Override
    public String getChannel() {
        return "SMS";
    }
}
