package sections;

import atm.AtmSection;
import models.Account;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AtmMenu {


    public static void atmSection(Scanner input) throws SQLException, ClassNotFoundException {

        String[] atmMenuItems = new String[5];

        atmMenuItems[0] = "(1) Deposit money";
        atmMenuItems[1] = "(2) Withdraw money";
        atmMenuItems[2] = "(3) Check balance";
        atmMenuItems[3] = "(4) View account details";
        atmMenuItems[4] = "(5) Exit";

        atmSubMenuSection(input, atmMenuItems);

    }

    private static void atmSubMenuSection(Scanner input, String[] atmMenuItems) throws SQLException, ClassNotFoundException {
        while (true){
            int selectedMenuItem = MenuUtil.printMenu(atmMenuItems, input);
            switch (selectedMenuItem){
                case 0:
                    depositMoney(input);
                    break;
                case 1:
                    withdrawMoney(input);
                    break;
                case 2:
                    checkBalance(input);
                    break;
                case 3:
                    viewAccountDetails(input);
                    break;
                case 4:
                    return;
            }
        }
    }

    private static void viewAccountDetails(Scanner input) throws SQLException, ClassNotFoundException {
        AtmSection.viewAccountDetails(input);
    }

    private static void checkBalance(Scanner input) throws SQLException, ClassNotFoundException {
        AtmSection.checkBalance(input);
    }

    private static void withdrawMoney(Scanner input) throws SQLException, ClassNotFoundException {
        AtmSection.withdrawMoney(input);
    }

    private static void depositMoney(Scanner input) throws SQLException, ClassNotFoundException {
        AtmSection.depositMoney(input);
    }

}
