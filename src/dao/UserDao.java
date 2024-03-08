package dao;

import models.User;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class UserDao {

    public static void viewAllPatients(List<User> users){
        users.forEach(System.out::println);
    }

    public static void deleteUser(List<User> users, Scanner input){
        System.out.println("Enter the user id");
        int id = input.nextInt();
        users.stream().filter(patient -> patient.getId() == id).findFirst();
        System.out.println("User has deleted!");
        users.stream().forEach(System.out::println);
    }

    public static void findUserById(List<User> users, Scanner input){
        System.out.println("Enter Patient id in order to Display!");
        int id = input.nextInt();
        Optional<User> findUser = users.stream().filter(user -> user.getId() == id).findFirst();
        System.out.println(findUser);
    }

    public static void updateUser(List<User> users, Scanner input){
        System.out.println("Enter the id in order to Update");
        int id = input.nextInt();
        User userToUpdate = users.get(id - 1);

        boolean updateStatus = true;

        while(updateStatus){

            System.out.println("Enter new Name");
            String newName = input.nextLine();
            userToUpdate.setName(newName);
            input.nextLine();

            System.out.println("Enter new Password");
            String newPassword = input.nextLine();
            userToUpdate.setPassword(newPassword);
            input.nextLine();

            System.out.println("User updated successfully!");
            updateStatus = false;
        }
        users.stream().forEach(System.out::println);

    }

    public static void addUser(List<User> users, Scanner input){
        boolean addStatus = true;
        while (addStatus){

            User user = new User();
            System.out.println("Enter User id");
            int id = input.nextInt();
            user.setId(id);
            input.nextLine();

            System.out.println("Enter user name");
            String name = input.nextLine();
            user.setName(name);
            input.nextLine();

            System.out.println("Enter user password");
            String password = input.nextLine();
            user.setPassword(password);
            input.nextLine();

            users.add(user);

            System.out.println("User added successfully!");

            System.out.println("Need to add another patient?");
            System.out.println("(1) Yes");
            System.out.println("(2) No");
            int answer = input.nextInt();

            if (answer != 1) {
                addStatus = false;
            } else {
                addStatus = true;
            }
        }
        users.stream().forEach(System.out::println);
    }
}
