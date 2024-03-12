package atm;

import dao.CrudUtil;
import models.Account;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class AtmSection {

    public static void depositMoney(Scanner input) throws SQLException, ClassNotFoundException {

        System.out.println("Enter Account Number");
        int number = input.nextInt();

        System.out.println("Enter amount you want to deposit?");
        double amount = input.nextDouble();

        CrudUtil.execute("UPDATE account SET balance = balance + ? WHERE number = ?", amount, number);

        System.out.println("Deposit completed!");

    }

    public static void withdrawMoney(Scanner input) throws SQLException, ClassNotFoundException {

        System.out.println("Enter Account Number");
        int number = input.nextInt();

        System.out.println("Enter amount you want to withdraw?");
        double amount = input.nextDouble();

        CrudUtil.execute("UPDATE account SET balance = balance - ? WHERE number = ?", amount, number);

        System.out.println("Withdrawal completed!");

    }

    public static void viewAccountDetails(Scanner input) throws SQLException, ClassNotFoundException {

        System.out.println("Enter Account Number");
        int number = input.nextInt();

        ResultSet set = CrudUtil.execute("SELECT * FROM account WHERE number = ?", number);
        ArrayList<Account> accountFind = new ArrayList<>();
        while(set.next()){
            accountFind.add(new Account(set.getInt(1), set.getInt(2), set.getString(3), set.getString(4),set.getDouble(5),set.getInt(6)));
        }
        accountFind.stream().forEach(account -> {
            System.out.println("Account Details");
            System.out.println("Name\t: " + account.getClientName());
            System.out.println("Account Number\t: " + account.getNumber());
            System.out.println();
        });
    }

    public static void checkBalance(Scanner input) throws SQLException, ClassNotFoundException {
        System.out.println("Enter Account Number");
        int number = input.nextInt();

        ResultSet set = CrudUtil.execute("SELECT * FROM account WHERE number = ?", number);
        ArrayList<Account> accountFind = new ArrayList<>();
        while(set.next()){
            accountFind.add(new Account(set.getInt(1), set.getInt(2), set.getString(3), set.getString(4),set.getDouble(5),set.getInt(6)));
        }
        accountFind.stream().forEach(account -> {
            System.out.println("Your current balance is : ");
            System.out.println("Rs. " + account.getBalance() + "/-");
            System.out.println();
        });
    }

}
