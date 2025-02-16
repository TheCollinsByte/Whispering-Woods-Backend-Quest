package com.thecollinsbyte.bank;

public class Account {
    private User user;
    private float balance;


    public Account(User user, float balance) {
        this.user = user;
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
