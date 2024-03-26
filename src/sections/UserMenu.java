package sections;

import dao.DaoFactory;
import dao.custom.UserDao;
import models.Account;
import models.Client;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserMenu {

    private static UserDao userDao = DaoFactory.getDao(DaoFactory.DaoType.USER);

    public static void userSection(Scanner input) throws SQLException, ClassNotFoundException {

        if(userDao.loginUser(input)){
            String[] userMainMenuItems = new String[3];
            userMainMenuItems[0] = "(1) Clients Section";
            userMainMenuItems[1] = "(2) Accounts Section";
            userMainMenuItems[2] = "(3) Exit";

            while(true){
                int selectedMenuItem = MenuUtil.printMenu(userMainMenuItems, input);

                switch (selectedMenuItem){
                    case 0:
                        ClientMenu.clientSection(input);
                        break;
                    case 1:
                        AccountMenu.accountSection(input);
                        break;
                    case 2:
                        return;
                }
            }
        }
    }
}
