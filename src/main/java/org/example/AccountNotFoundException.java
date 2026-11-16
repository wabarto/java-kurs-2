package org.example;

import lombok.Getter;

@Getter
public class AccountNotFoundException extends BankException {
    private final String accountNumber;

    AccountNotFoundException(String accountNumber) {
        super("Account not found", "ACCOUNT_NOT_FOUND");
        this.accountNumber = accountNumber;
    }
}
