package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.AccountDao;
import models.Account;
import models.User;
import util.GlobalVar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class AccountDaoImpl implements AccountDao {

    public void viewAll(List<Account> accounts) throws SQLException, ClassNotFoundException {
        ResultSet set =  CrudUtil.execute("SELECT * FROM account");
        ArrayList<Account> accountsFind = new ArrayList<>();

        while (set.next()){
            accountsFind.add(new Account(set.getInt(1),set.getInt(2),set.getString(3),set.getString(4),set.getDouble(5),set.getInt(6)));
        }
        System.out.println(accountsFind);
    }

    public void delete(List<Account> accounts, Scanner input) throws SQLException, ClassNotFoundException {
        System.out.println("Enter the account id");
        int id = input.nextInt();

        if(CrudUtil.execute("DELETE FROM account WHERE account_id = ?", id)){
            System.out.println("Account has deleted");
        } else {
            System.out.println("Sorry client cannot be delete");
        }

    }

    public void findById(List<Account> accounts, Scanner input) throws SQLException, ClassNotFoundException {
        System.out.println("Enter Account id in order to Display!");
        int id = input.nextInt();

        ResultSet set = CrudUtil.execute("SELECT * FROM account WHERE account_id = ?", id);
        ArrayList<Account> accountFind = new ArrayList<>();

        while(set.next()){
            accountFind.add(new Account(set.getInt(1),set.getInt(2),set.getString(3),set.getString(4),set.getDouble(5),set.getInt(6)));
        }

        System.out.println(accountFind);

    }

    public void update(List<Account> accounts, Scanner input) throws SQLException, ClassNotFoundException {
        System.out.println("Enter account id in order to Update");
        int id = input.nextInt();
//        Account updateAccount = accounts.get(id - 1);

        boolean updateStatus = true;

        while(updateStatus){

            System.out.println("Enter new Number");
            int newNumber = input.nextInt();
            input.nextLine();

            System.out.println("Enter new Client name");
            String newName = input.nextLine();

            System.out.println("Enter new Pin Number");
            int newPin = input.nextInt();

            System.out.println("Enter new Balance");
            double newBalance = input.nextDouble();

            CrudUtil.execute("UPDATE account SET number = ?, pin = ?, client_name = ?, balance = ? WHERE account_id = ?", newNumber, newPin, newName, newBalance, id);

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

            System.out.println("Enter client id here");
            int clientId = input.nextInt();

            Account account = new Account(0,number,pin,name,balance, clientId);

            Object executedQuery = CrudUtil.execute("INSERT INTO account(account_id, number, pin, client_name, balance, client_client_id) VALUES (?,?,?,?,?,?)", account.getAccount_id(), account.getNumber(), account.getPin(), account.getClientName(), account.getBalance(), account.getClient_client_id());

            if(executedQuery != null){
                System.out.println("Account added successfully!");
            } else {
                System.out.println("Something went wrong!");
            }

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
