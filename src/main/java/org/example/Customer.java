package org.example;

public class Customer {
    private final String name;
    private final Address residenceAddress;
    private final Address mailingAddress;

    public Customer(String name, Address residence, Address mailing) {
        this.name = name;
        this.residenceAddress = residence;
        this.mailingAddress = mailing;
    }
}
