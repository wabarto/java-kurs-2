package org.example;

// DTO - Data Transfer Object - nosnik danych
record StatementDTO(String accountNumber, String accountType, double balance) {
    StatementDTO { // konstruktor kompaktowy
        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException("Account number is required");
        }
        accountNumber = accountNumber.toUpperCase();
    }

    // wlasne metody
    public String formatted() {
        return "123";
    }

    // metoda wytworcza
    public static StatementDTO from(BankAccount account) {
        return new StatementDTO(account.getAccountNumber(), account.getAccountType(), account.getBalance());
    }
}

