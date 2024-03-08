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
        if(account != null) {
            System.out.println(account.toString());
        } else {
            System.out.println("Sorry account doesn't exist!");
        }

        System.out.println("Enter amount for deposit");
        double amount = input.nextDouble();

        account.setBalance(account.getBalance() + amount);
        System.out.println("Your total balance : " + account.getBalance());

    }

    public static void withdrawMoney(List<Account> accounts, Scanner input){

        System.out.println("Enter Account Number");
        int number = input.nextInt();
        Optional<Account> findAccount = accounts.stream().filter(account -> account.getNumber() == number).findFirst();
        Account account = findAccount.get();
        if(account != null) {
            System.out.println(account.toString());
        } else {
            System.out.println("Sorry account doesn't exist!");
        }

        System.out.println("Enter amount for withdraw");
        double amount = input.nextDouble();

        account.setBalance(account.getBalance() - amount);
        System.out.println("Your total balance : " + account.getBalance());
    }

    public static void viewAccountDetails(List<Account> accounts, Scanner input){

        System.out.println("Enter Account Number");
        int number = input.nextInt();
        Optional<Account> findAccount = accounts.stream().filter(account -> account.getNumber() == number).findFirst();
        Account account = findAccount.get();
        if(account != null) {
            System.out.println("Account Number\t:" + account.getNumber());
            System.out.println("Client name\t:" + account.getClientName());
        } else {
            System.out.println("Sorry account doesn't exist!");
        }
    }

    public static void checkBalance(List<Account> accounts, Scanner input){
        System.out.println("Enter Account Number");
        int number = input.nextInt();
        Optional<Account> findAccount = accounts.stream().filter(account -> account.getNumber() == number).findFirst();
        Account account = findAccount.get();
        if(account != null) {
            System.out.println("Account Number\t:" + account.getBalance());
        } else {
            System.out.println("Sorry account doesn't exist!");
        }
    }

}
