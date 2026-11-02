package org.example;

public enum AccountStatus {
    ACTIVE("Konto czynne", true, true),
    BLOCKED("Konto zablokowane", true, false),
    CLOSED("Konto zamknięte", false, false);

    private final String label;
    private final boolean canDeposit;
    private final boolean canWithdraw;


    AccountStatus(String label, boolean canDeposit, boolean canWithdraw) {
        this.label = label;
        this.canDeposit = canDeposit;
        this.canWithdraw = canWithdraw;
    }

    public String getLabel() {
        return label;
    }

    public boolean canDeposit() {
        return canDeposit;
    }

    public boolean canWithdraw() {
        return canWithdraw;
    }

}
