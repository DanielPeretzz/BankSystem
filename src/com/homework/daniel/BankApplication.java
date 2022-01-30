package com.homework.daniel;

import com.homework.daniel.banksystem.BankStatistics;
import com.homework.daniel.banksystem.BankSystem;

import com.homework.daniel.util.Util;

import java.util.Scanner;

public class BankApplication {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        while (BankSystem.instance.isRunning()) {
            BankSystem.instance.showMenu();
            int answer = SCANNER.nextInt();
            switch (answer) {
                case 1:
                    Util.createClient();
                    break;
                case 2:
                    Util.deleteClient();
                    break;
                case 3:
                    Util.withdrawMoney();
                    break;
                case 4:
                    Util.depositMoney();
                    break;
                case 5:
                    BankSystem.instance.printAll();
                    break;
                case 6:
                    BankStatistics.richClient();
                    break;
                case 7:
                    BankStatistics.poorest();
                    break;
                case 8:
                    BankStatistics.amountOfBank();
                    break;
                case 9:
                    System.out.println("thread stop running");
                    BankSystem.instance.setRunning(false);
            }
        }
    }
}
