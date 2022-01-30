package com.homework.daniel.model.client;

import com.homework.daniel.model.Account;

public class VipClient extends Client{
    public VipClient(int id, String name, double age, float interestRate, Account account) {
        super(id, name, age, interestRate, account);
    }
}
