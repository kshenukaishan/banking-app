import models.Account;
import models.Client;
import models.User;
import sections.AdminMenu;
import sections.AtmMenu;
import sections.MenuUtil;
import sections.UserMenu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        System.out.println("Welcome to Banking System!");
        System.out.println("--------------------------");

        Scanner input = new Scanner(System.in);
        String[] menuItems = new String[4];

        List<User> users = new ArrayList<>();
        List<Client> clients = new ArrayList<>();
        List<Account> accounts = new ArrayList<>();

        menuItems[0] = "(1) Admin section";
        menuItems[1] = "(2) User's section";
        menuItems[2] = "(3) Client's section";
        menuItems[3] = "(4) Exit";


        while(true){

        int selectedMenuItem = MenuUtil.printMenu(menuItems, input);

            switch (selectedMenuItem){
                case 0:
                    System.out.println("You are in Admin Section");
                    AdminMenu.adminSection(users, input);
                    break;
                case 1:
                    System.out.println("You are in User Section");
                    UserMenu.userSection(clients, accounts, input);
                    break;
                case 2:
                    System.out.println("You are in Client section");
                    AtmMenu.atmSection(accounts, input);
                    break;
                case 3:
                    System.out.println("Thank you!");
                    System.exit(0);
            }
        }
    }
}
