package org.example;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class InsufficientFundsException extends BankException {
    private final BigDecimal requested;
    private final BigDecimal available;

    InsufficientFundsException(BigDecimal requested, BigDecimal available) {
        super("not enough money, requested: %.2f, available: %.2f".formatted(requested, available), "INSUFFICIENT_FUNDS");
        this.requested = requested;
        this.available = available;
    }
}
