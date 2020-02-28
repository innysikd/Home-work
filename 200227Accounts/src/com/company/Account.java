package com.company;

public class Account {

    private String accountNumber;
    private long balance;
    private boolean isLocked;

    public Account(String accountNumber, long balance, boolean isLocked) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.isLocked = isLocked;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }

    public boolean isLocked() {
        return isLocked;
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber +
                ", balance = " + balance +
                ", isLocked = " + isLocked;
    }
}
