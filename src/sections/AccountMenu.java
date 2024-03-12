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

    public static void accountSection(Scanner input) throws SQLException, ClassNotFoundException {

        String[] accountMenuItems = new String[6];

        accountMenuItems[0] = "(1) Add Account";
        accountMenuItems[1] = "(2) Find Account";
        accountMenuItems[2] = "(3) Update Account";
        accountMenuItems[3] = "(4) Delete Account";
        accountMenuItems[4] = "(5) View All Account";
        accountMenuItems[5] = "(6) Exit";

        accountSubMenu(input, accountMenuItems);

    }

    private static void accountSubMenu(Scanner input, String[] accountMenuItems) throws SQLException, ClassNotFoundException {
        while(true){
            int selectedMenuItem = MenuUtil.printMenu(accountMenuItems, input);

            switch (selectedMenuItem){
                case 0:
                    addAccount(input);
                    break;
                case 1:
                    findAccount(input);
                    break;
                case 2:
                    updateAccount(input);
                    break;
                case 3:
                    deleteAccount(input);
                    break;
                case 4:
                    viewAllAccount();
                    break;
                case 5:
                    return;
            }
        }
    }

    private static void viewAllAccount() throws SQLException, ClassNotFoundException {
        accountDao.viewAll();
    }

    private static void deleteAccount(Scanner input) throws SQLException, ClassNotFoundException {
        accountDao.delete(input);
    }

    private static void updateAccount(Scanner input) throws SQLException, ClassNotFoundException {
        accountDao.update(input);
    }

    private static void findAccount(Scanner input) throws SQLException, ClassNotFoundException {
        accountDao.findById(input);
    }

    private static void addAccount(Scanner input) throws SQLException, ClassNotFoundException {
        accountDao.add(input);
    }
}
