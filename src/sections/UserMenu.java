package sections;

import models.Account;
import models.Client;

import java.util.List;
import java.util.Scanner;

public class UserMenu {

    public static void userSection(List<Client> clients, List<Account> accounts,  Scanner input){

        String[] userMainMenuItems = new String[3];
        userMainMenuItems[0] = "(1) Clients Section";
        userMainMenuItems[1] = "(2) Accounts Section";
        userMainMenuItems[2] = "(3) Exit";

        while(true){
            int selectedMenuItem = MenuUtil.printMenu(userMainMenuItems, input);

            switch (selectedMenuItem){
                case 0:
                    ClientMenu.clientSection(clients, input);
                    break;
                case 1:
                    System.out.println("Account Section");
                    break;
                case 2:
                    return;
            }
        }
    }
}
