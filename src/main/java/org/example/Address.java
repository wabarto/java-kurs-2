package org.example;

import lombok.Getter;

import java.util.Optional;

@Getter
public class Address{

    String name;


    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }
}
