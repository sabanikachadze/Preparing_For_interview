package org.example.Pojos;

public class Wallet {
    private int balance;

    public Wallet(int balance) {
        this.balance = balance;
    }

    public int withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be positive");
        }
        if (amount > balance) {
            throw new IllegalStateException("not enough money");
        }
        balance -= amount;
        return balance;
    }
}