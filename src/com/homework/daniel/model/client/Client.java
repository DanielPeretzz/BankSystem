package com.homework.daniel.model.client;

import com.homework.daniel.model.Account;
import com.homework.daniel.model.Person;

public abstract class Client extends Person {
    private float interestRate;
    private Account account;

    public Client(int id, String name, double age, float interestRate, Account account) {
        super(id, name, age);
        this.interestRate = interestRate;
        this.account = account;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Client{" +
                "interestRate=" + interestRate +
                ", account=" + account +
                "} " + super.toString();
    }
}

