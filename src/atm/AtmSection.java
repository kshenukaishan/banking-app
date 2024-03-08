package atm;

import models.Account;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class AtmSection {

    public static void depositMoney(List<Account> accounts, Scanner input){

        System.out.println("Enter Account Number");
        int number = input.nextInt();
        Optional<Account> findAccount = accounts.stream().filter(account -> account.getNumber() == number).findFirst();
        Account account = findAccount.get();
        System.out.println(account.toString());

        System.out.println("Enter amount for deposit");
        double amount = input.nextDouble();

        account.setBalance(account.getBalance() + amount);
        System.out.println("Your total balance : " + account.getBalance());

    }

}
