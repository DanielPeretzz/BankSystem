package com.homework.daniel.util;

import com.homework.daniel.banksystem.BankSystem;
import com.homework.daniel.constance.Constance;
import com.homework.daniel.model.Account;
import com.homework.daniel.model.client.Client;
import com.homework.daniel.model.client.RegularClient;
import com.homework.daniel.model.client.VipClient;

import java.util.Objects;
import java.util.Scanner;

public class Util {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void createClient() {
        System.out.println("please enter R for regular client or V for VIP client");
        String answer = SCANNER.next();
        System.out.println("please enter your id : ");
        int id = SCANNER.nextInt();
        System.out.println("please enter your name : ");
        String name = SCANNER.next();
        System.out.println("please enter your age :");
        double age = SCANNER.nextDouble();

        if (Objects.equals(answer, "R")) {
            BankSystem.instance.addClient(id, name, age, Constance.interestRateReg, new Account(0.0));
        }
        else if (Objects.equals(answer, "V")){
            BankSystem.instance.addClient(id, name, age, Constance.interestRateVip, new Account(0.0));
        }

    }

    public static void  withdrawMoney(){
        System.out.println("please enter your id :");
        int id = SCANNER.nextInt();
        System.out.println("please enter amount to withdraw : ");
        double money =  SCANNER.nextDouble();
        BankSystem.instance.withdraw(id,money);
    }

    public static void depositMoney(){
        System.out.println("please enter your id to deposit : ");
        int id = SCANNER.nextInt();
        System.out.println("please enter your amount of money to deposit : ");
        double money = SCANNER.nextDouble();
        BankSystem.instance.deposit(id,money);

    }

    public static void deleteClient() {
        System.out.println("please enter your id to delete account : ");
        int id = SCANNER.nextInt();
        BankSystem.instance.deleteClient(id);

    }

}
