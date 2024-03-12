package sections;

import dao.DaoFactory;
import dao.custom.UserDao;
import dao.custom.impl.UserDaoImpl;
import models.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AdminMenu {

    private static UserDao userDao = DaoFactory.getDao(DaoFactory.DaoType.USER);

    public static void adminSection(Scanner input) throws SQLException, ClassNotFoundException {

        String[] adminMenuItems = new String[6];

        adminMenuItems[0] = "(1) Add User";
        adminMenuItems[1] = "(2) Find User";
        adminMenuItems[2] = "(3) Update User";
        adminMenuItems[3] = "(4) Delete User";
        adminMenuItems[4] = "(5) View All DUser";
        adminMenuItems[5] = "(6) Exit";

            subMenuSection(input, adminMenuItems);
    }

    private static void subMenuSection(Scanner input, String[] adminMenuItems) throws SQLException, ClassNotFoundException {

        while (true){
            int selectedMenuItem = MenuUtil.printMenu(adminMenuItems, input);

            switch (selectedMenuItem){
                case 0:
                    addUser(input);
                    break;
                case 1:
                    findUserById(input);
                    break;
                case 2:
                    updateUser(input);
                    break;
                case 3:
                    deleteUser(input);
                    break;
                case 4:
                    viewAllUsers();
                    break;
                case 5:
                    return;
            }
        }
    }

    private static void viewAllUsers() throws SQLException, ClassNotFoundException {
        userDao.viewAll();
    }

    private static void findUserById(Scanner input) throws SQLException, ClassNotFoundException {
        userDao.findById(input);
    }

    private static void updateUser(Scanner input) throws SQLException, ClassNotFoundException {
        userDao.update(input);
    }

    private static void deleteUser(Scanner input) throws SQLException, ClassNotFoundException {
        userDao.delete(input);
    }

    private static void addUser(Scanner input) throws SQLException, ClassNotFoundException {
        userDao.add(input);
    }
}
