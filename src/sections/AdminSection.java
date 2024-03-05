package sections;

import models.User;

import java.util.List;
import java.util.Scanner;

public class AdminSection {

    public static void adminSection(List<User> users){

        String[] adminMenuItems = new String[6];

        adminMenuItems[0] = "(1) Add User";
        adminMenuItems[1] = "(2) Find User";
        adminMenuItems[2] = "(3) Update User";
        adminMenuItems[3] = "(4) Delete User";
        adminMenuItems[4] = "(5) View All DUser";
        adminMenuItems[5] = "(6) Exit";

    }

    private static void subMenuSection(List<User> users, Scanner input, String[] userMenuItems){

        while (true){
            int selectedMenuItem = MenuUtil.printMenu(userMenuItems, input);

            switch (selectedMenuItem){
                case 0:
                    System.out.println("add user");
                    break;
                case 1:
                    System.out.println("Find user");
                    break;
                case 2:
                    System.out.println("Update user");
                    break;
                case 3:
                    System.out.println("Delete user");
                    break;
                case 4:
                    System.out.println("View all users");
                    break;
                case 5:
                    return;
            }
        }
    }


}
