package com.homework.daniel.runnbletask;

import com.homework.daniel.banksystem.BankSystem;
import com.homework.daniel.model.client.Client;

import java.util.TreeSet;

public class InterestTask implements Runnable {
    private final TreeSet<Client> clients;

    public InterestTask(TreeSet<Client> clients) {
        this.clients = clients;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread() + " has started to run");
        while(true){

            try {
                if(BankSystem.instance.getClients().size() >= 1){
                    for (Client client : BankSystem.instance.getClients()) {
                        double prevBalance = client.getAccount().getBalance();
                        System.out.println("Current balance: " + prevBalance + "$");

                        client.getAccount().setBalance(prevBalance - (prevBalance * client.getInterestRate()));
                        System.out.println(client.getName() + " with id: " + client.getId()
                                + " with the updated balance: " + client.getAccount().getBalance() + "$");
                        System.out.println(Thread.currentThread() + " went to sleep");
                    }
                }
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
