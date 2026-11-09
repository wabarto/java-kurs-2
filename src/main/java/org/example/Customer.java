package org.example;

import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
public class Customer {

    @Getter
    private final String name;

    private final Address residenceAddress;

    @Setter
    private final Address mailingAddress;

    public Customer(String name, Address residence, Address mailing) {
        this.name = name;
        this.residenceAddress = residence;
        this.mailingAddress = mailing;
    }
}
