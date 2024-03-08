package sections;

import dao.AccountDao;
import models.Account;

import java.util.List;
import java.util.Scanner;

public class AccountMenu {

    public static void accountSection(List<Account> accounts, Scanner input){

        String[] accountMenuItems = new String[6];

        accountMenuItems[0] = "(1) Add Account";
        accountMenuItems[1] = "(2) Find Account";
        accountMenuItems[2] = "(3) Update Account";
        accountMenuItems[3] = "(4) Delete Account";
        accountMenuItems[4] = "(5) View All Account";
        accountMenuItems[5] = "(6) Exit";

        accountSubMenu(accounts, input, accountMenuItems);

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
                    viewAllAccount(accounts);
                    break;
                case 5:
                    return;
            }
        }
    }

    private static void viewAllAccount(List<Account> accounts) {
        AccountDao.viewAllAccounts(accounts);
    }

    private static void deleteAccount(List<Account> accounts, Scanner input) {
        AccountDao.deleteAccount(accounts, input);
    }

    private static void updateAccount(List<Account> accounts, Scanner input) {
        AccountDao.updateAccount(accounts, input);
    }

    private static void findAccount(List<Account> accounts, Scanner input) {
        AccountDao.findAccountById(accounts, input);
    }

    private static void addAccount(List<Account> accounts, Scanner input) {
        AccountDao.addAccount(accounts, input);
    }
}
