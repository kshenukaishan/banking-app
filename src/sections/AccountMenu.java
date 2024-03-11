package sections;

import dao.DaoFactory;
import dao.custom.AccountDao;
import dao.custom.impl.AccountDaoImpl;
import models.Account;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AccountMenu {

    private static AccountDao accountDao = DaoFactory.getDao(DaoFactory.DaoType.ACCOUNT);

    public static void accountSection(List<Account> accounts, Scanner input) throws SQLException, ClassNotFoundException {

        String[] accountMenuItems = new String[6];

        accountMenuItems[0] = "(1) Add Account";
        accountMenuItems[1] = "(2) Find Account";
        accountMenuItems[2] = "(3) Update Account";
        accountMenuItems[3] = "(4) Delete Account";
        accountMenuItems[4] = "(5) View All Account";
        accountMenuItems[5] = "(6) Exit";

        accountSubMenu(accounts, input, accountMenuItems);

    }

    private static void accountSubMenu(List<Account> accounts, Scanner input, String[] accountMenuItems) throws SQLException, ClassNotFoundException {
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

    private static void viewAllAccount(List<Account> accounts) throws SQLException, ClassNotFoundException {
        accountDao.viewAll(accounts);
    }

    private static void deleteAccount(List<Account> accounts, Scanner input) {
        accountDao.delete(accounts, input);
    }

    private static void updateAccount(List<Account> accounts, Scanner input) {
        accountDao.update(accounts, input);
    }

    private static void findAccount(List<Account> accounts, Scanner input) throws SQLException, ClassNotFoundException {
        accountDao.findById(accounts, input);
    }

    private static void addAccount(List<Account> accounts, Scanner input) throws SQLException, ClassNotFoundException {
        accountDao.add(accounts, input);
    }
}
