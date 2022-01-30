package com.homework.daniel.banksystem;


import com.homework.daniel.exception.DeleteException;
import com.homework.daniel.exception.WithdrawException;
import com.homework.daniel.model.Account;
import com.homework.daniel.model.client.Client;
import com.homework.daniel.model.client.RegularClient;
import com.homework.daniel.model.client.VipClient;
import com.homework.daniel.runnbletask.InterestTask;


import java.util.*;

public class BankSystem {
    public static final BankSystem instance = new BankSystem();

    private BankSystem() {
        isRunning = true;
        Thread bankThread = new Thread(task);
        bankThread.start();
        System.out.println("Thread start running! \n");
    }

    private Thread bankThread;
    private InterestTask task;
    private TreeSet<Client> clients = new TreeSet<Client>(Comparator.comparing(client -> client.getAccount().getBalance()));
    private final Scanner scanner = new Scanner(System.in);
    private boolean isRunning;

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public Thread getBankThread() {
        return bankThread;
    }

    public void setBankThread(Thread bankThread) {
        this.bankThread = bankThread;
    }

    public InterestTask getTask() {
        return task;
    }

    public void setTask(InterestTask task) {
        this.task = task;
    }

    public TreeSet<Client> getClients() {
        return clients;
    }

    public void setClients(TreeSet<Client> clients) {
        this.clients = clients;
    }

    public Scanner getScanner() {
        return scanner;
    }


    @Override
    public String toString() {
        return "BankSystem{" +
                "bankThread=" + bankThread +
                ", task=" + task +
                ", clients=" + clients +
                ", scanner=" + scanner +
                ", isRunning=" + isRunning +
                '}';
    }

    public void showMenu() {
        System.out.println("Hello Dear client \nadd new account press - 1\nremove your account press - 2\n" +
                "withdraw money press - 3\ndeposit money press - 4\nview all the client in the bank press 5\n" +
                "The richest client press - 6\n The poorest client press - 7\nBank balance press - 8" +
                "\nExit press - 9");
    }

    public void addClient(int id, String name, double age, float interestRate, Account account) {

        if (interestRate == 0.05f) {
            RegularClient regularClient = new RegularClient(id, name, age, interestRate, account);
            getClients().add(regularClient);
        } else {
            VipClient vipClient = new VipClient(id, name, age, interestRate, account);
            getClients().add(vipClient);
        }

    }

    public void deleteClient(int id) {
        for (Client client : getClients()) {
            if (client.getId() == id) {
                try {
                    if (client.getAccount().getBalance() == 0) {
                        throw new DeleteException(new Date());
                    }
                    else {
                        getClients().remove(client);
                    }
                } catch (DeleteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void withdraw(int id, double amount) {
        for (Client client : getClients()) {
            if (client.getId() == id) {
                try {
                    if (client.getAccount().getBalance() >= amount) {
                        client.getAccount().setBalance(client.getAccount().getBalance() - amount);
                        System.out.println("withdraw : " + amount);
                    } else {
                        throw new WithdrawException(new Date());
                    }
                } catch (WithdrawException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void deposit(int id, double amount) {
        for (Client client : getClients()) {
            if (client.getId() == id) {
                client.getAccount().setBalance(client.getAccount().getBalance() + amount);
            }
        }
    }

    public void printAll() {
        clients.forEach(System.out::println);
    }


}
