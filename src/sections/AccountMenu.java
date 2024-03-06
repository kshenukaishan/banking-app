package sections;

import models.Account;
import models.Client;

import java.util.List;
import java.util.Scanner;

public class AccountMenu {

    public static void accountSection(List<Account> accounts, Scanner input){

        String[] accountMenuItems = new String[6];

        accountMenuItems[0] = "(1) Add Client";
        accountMenuItems[1] = "(2) Find Client";
        accountMenuItems[2] = "(3) Update Client";
        accountMenuItems[3] = "(4) Delete Client";
        accountMenuItems[4] = "(5) View All Clients";
        accountMenuItems[5] = "(6) Exit";

    }

    private static void accountSubMenu(List<Account> accounts, Scanner input, String[] accountMenuItems){
        while(true){
            int selectedMenuItem = MenuUtil.printMenu(accountMenuItems, input);

            switch (selectedMenuItem){
                case 0:
                    addAccount(accounts, input);
                    break;
                case 1:
                    findAccount(accounts, input);
                    break;
                case 2:
                    updateAccount(accounts, input);
                    break;
                case 3:
                    deleteAccount(accounts, input);
                    break;
                case 4:
                    viewAllAccount(accounts, input);
                    break;
                case 5:
                    return;
            }
        }
    }

    private static void viewAllAccount(List<Account> accounts, Scanner input) {
        System.out.println("view account");
    }

    private static void deleteAccount(List<Account> accounts, Scanner input) {
        System.out.println("Delete account");
    }

    private static void updateAccount(List<Account> accounts, Scanner input) {
        System.out.println("update account");
    }

    private static void findAccount(List<Account> accounts, Scanner input) {
        System.out.println("find account");
    }

    private static void addAccount(List<Account> accounts, Scanner input) {
        System.out.println("add account");
    }


}
