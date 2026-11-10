package org.example;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

//@Getter
//@Setter
//@NoArgsConstructor(force = true)
//@AllArgsConstructor
//@RequiredArgsConstructor
//@ToString(callSuper = true, onlyExplicitlyIncluded = true)
//@EqualsAndHashCode(callSuper = true, of = "name")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
//@Data // @Getter + @Setter + @ToString + @EqualsAndHashCode + @RequiredArgsConstructor
//@Value // @Getter + @ToString + @EqualsAndHashCode + @AllArgsConstructor + wszystkie pola final i klasa final
@AllArgsConstructor
@SuperBuilder
public class Customer extends Person {

    @Getter(AccessLevel.NONE)
    @With
    @NonNull
    private final String name;


    @ToString.Include
    private final Address residenceAddress;

    private final Address mailingAddress;

    @Builder.Default
    private int count = 10;

    @Singular
    private List<String> tags;

//    public Customer(String name, Address residence, Address mailing) {
//        this.name = name;
//        this.residenceAddress = residence;
//        this.mailingAddress = mailing;
//    }
}
