package sections;

import atm.AtmSection;
import models.Account;

import java.util.List;
import java.util.Scanner;

public class AtmMenu {


    public static void atmSection(List<Account> accounts, Scanner input){

        String[] atmMenuItems = new String[5];

        atmMenuItems[0] = "(1) Deposit money";
        atmMenuItems[1] = "(2) Withdraw money";
        atmMenuItems[2] = "(3) Check balance";
        atmMenuItems[3] = "(4) View account details";
        atmMenuItems[4] = "(5) Exit";

        atmSubMenuSection(accounts, input, atmMenuItems);

    }

    private static void atmSubMenuSection(List<Account> accounts, Scanner input, String[] atmMenuItems){
        while (true){
            int selectedMenuItem = MenuUtil.printMenu(atmMenuItems, input);
            switch (selectedMenuItem){
                case 0:
                    depositMoney(accounts, input);
                    break;
                case 1:
                    withdrawMoney(accounts, input);
                    break;
                case 2:
                    checkBalance(accounts, input);
                    break;
                case 3:
                    viewAccountDetails(accounts, input);
                    break;
                case 4:
                    return;
            }
        }
    }

    private static void viewAccountDetails(List<Account> accounts, Scanner input) {
        System.out.println("View account details");
    }

    private static void checkBalance(List<Account> accounts, Scanner input) {
        System.out.println("Check balance");
    }

    private static void withdrawMoney(List<Account> accounts, Scanner input) {
        AtmSection.withdrawMoney(accounts, input);
    }

    private static void depositMoney(List<Account> accounts, Scanner input) {
        AtmSection.depositMoney(accounts, input);
    }

}
