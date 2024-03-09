package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.AccountDao;
import models.Account;
import util.GlobalVar;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class AccountDaoImpl implements AccountDao {

    public void viewAll(List<Account> accounts){
        accounts.forEach(System.out::println);
    }

    public void delete(List<Account> accounts, Scanner input){
        System.out.println("Enter the account id");
        int id = input.nextInt();
        accounts.stream().filter(patient -> patient.getAccount_id() == id).findFirst();
        System.out.println("Account has deleted!");
        accounts.stream().forEach(System.out::println);
    }

    public void findById(List<Account> accounts, Scanner input){
        System.out.println("Enter Account id in order to Display!");
        int id = input.nextInt();
        Optional<Account> findAccount = accounts.stream().filter(account -> account.getAccount_id() == id).findFirst();
        System.out.println(findAccount);
    }

    public void update(List<Account> accounts, Scanner input){
        System.out.println("Enter account id in order to Update");
        int id = input.nextInt();
        Account updateAccount = accounts.get(id - 1);

        boolean updateStatus = true;

        while(updateStatus){

            System.out.println("Enter new Number");
            int newNumber = input.nextInt();
            updateAccount.setNumber(newNumber);
            input.nextLine();

            System.out.println("Enter new Client name");
            String newName = input.nextLine();
            updateAccount.setClientName(newName);
            input.nextLine();

            System.out.println("Enter new Balance");
            double newBalance = input.nextDouble();
            updateAccount.setBalance(newBalance);

            System.out.println("Account updated successfully!");
            updateStatus = false;
        }
        accounts.stream().forEach(System.out::println);
    }

    public void add(List<Account> accounts, Scanner input) throws SQLException, ClassNotFoundException {
        boolean addStatus = true;
        while (addStatus){

            System.out.println("Enter Account number");
            int number = input.nextInt();
            input.nextLine();

            System.out.println("Enter Account pin");
            String pin = input.nextLine();

            System.out.println("Enter Holder's name");
            String name = input.nextLine();

            System.out.println("Enter initial balance");
            double balance = input.nextDouble();

            Account account = new Account(0,number,pin,name,balance, GlobalVar.clientId);

            CrudUtil.execute("INSERT INTO account(account_id, number, pin, client_name, balance, client_client_id) VALUES (?,?,?,?,?,?)", account.getAccount_id(), account.getNumber(), account.getPin(), account.getClientName(), account.getBalance(), account.getClient_client_id());

            System.out.println("Account added successfully!");

            System.out.println("Need to add another account?");
            System.out.println("(1) Yes");
            System.out.println("(2) No");
            int answer = input.nextInt();

            if (answer != 1) {
                addStatus = false;
            } else {
                addStatus = true;
            }
        }
        accounts.stream().forEach(System.out::println);
    }

}
