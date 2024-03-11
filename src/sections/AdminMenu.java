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

    public static void adminSection(List<User> users, Scanner input) throws SQLException, ClassNotFoundException {

        String[] adminMenuItems = new String[6];

        adminMenuItems[0] = "(1) Add User";
        adminMenuItems[1] = "(2) Find User";
        adminMenuItems[2] = "(3) Update User";
        adminMenuItems[3] = "(4) Delete User";
        adminMenuItems[4] = "(5) View All DUser";
        adminMenuItems[5] = "(6) Exit";

            subMenuSection(users, input, adminMenuItems);
    }

    private static void subMenuSection(List<User> users, Scanner input, String[] adminMenuItems) throws SQLException, ClassNotFoundException {

        while (true){
            int selectedMenuItem = MenuUtil.printMenu(adminMenuItems, input);

            switch (selectedMenuItem){
                case 0:
                    addUser(users, input);
                    break;
                case 1:
                    findUserById(users, input);
                    break;
                case 2:
                    updateUser(users, input);
                    break;
                case 3:
                    deleteUser(users, input);
                    break;
                case 4:
                    viewAllUsers(users);
                    break;
                case 5:
                    return;
            }
        }
    }

    private static void viewAllUsers(List<User> users) throws SQLException, ClassNotFoundException {
        userDao.viewAll(users);
    }

    private static void findUserById(List<User> users, Scanner input) throws SQLException, ClassNotFoundException {
        userDao.findById(users, input);
    }

    private static void updateUser(List<User> users, Scanner input){
        userDao.update(users, input);
    }

    private static void deleteUser(List<User> users, Scanner input){
        userDao.delete(users, input);
    }

    private static void addUser(List<User> users, Scanner input) throws SQLException, ClassNotFoundException {
        userDao.add(users, input);
    }
}
