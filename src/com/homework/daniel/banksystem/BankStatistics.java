package com.homework.daniel.banksystem;

import com.homework.daniel.model.client.Client;

public class BankStatistics {

    public static int countMembers(){
        int numOfMembers = 0;
        for (Client client: BankSystem.instance.getClients()) {
            numOfMembers ++;
        }
        return numOfMembers;
    }

    public static void amountOfBank(){
        double sumOfMoney = 0;
        for (Client client:BankSystem.instance.getClients()) {
            sumOfMoney += client.getAccount().getBalance();
        }
        System.out.println("Bank balance : " + sumOfMoney);
    }

    public static void richClient(){
        double highestMoney = 0;
        Client rich = null;
        for (Client client: BankSystem.instance.getClients()) {
            if (client.getAccount().getBalance() > highestMoney){
                highestMoney = client.getAccount().getBalance();
                rich = client;
            }
        }
        assert rich != null;
        System.out.println(rich.getName() +" richest in the bank with : " + highestMoney + "$ in balance");
    }

    public static void poorest(){
        double lowestMoney = Double.MAX_VALUE;
        Client poor = null;
        for (Client client:BankSystem.instance.getClients()) {
            if (client.getAccount().getBalance() < lowestMoney){
                lowestMoney = client.getAccount().getBalance();
                poor = client;
            }
        }
        assert poor != null;
        System.out.println(poor.getName() + "is the poorest in the bank with : " + lowestMoney + "$ in balance");
    }

}
