package com.homework.daniel.exception;

import com.homework.daniel.model.client.Client;

import java.util.Date;

public class WithdrawException extends Exception{
    private Date timeStamp;

    public WithdrawException(Date timeStamp) {
        super("sorry but you don't have money to withdraw ! " + timeStamp);
        this.timeStamp = timeStamp;
    }





}
