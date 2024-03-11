package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.UserDao;
import models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class UserDaoImpl implements UserDao {

    public void viewAll(List<User> users){
        users.forEach(System.out::println);
    }

    public void delete(List<User> users, Scanner input){
        System.out.println("Enter the user id");
        int id = input.nextInt();
        users.stream().filter(patient -> patient.getId() == id).findFirst();
        System.out.println("User has deleted!");
        users.stream().forEach(System.out::println);
    }

    public void findById(List<User> users, Scanner input) throws SQLException, ClassNotFoundException {
        System.out.println("Enter user id in order to Display!");
        int id = input.nextInt();

        ResultSet set = CrudUtil.execute("SELECT * FROM user WHERE id = ?", id);
            ArrayList<User> usersFind = new ArrayList<>();
        while(set.next()){
            usersFind.add(new User(set.getInt(1), set.getString(2), set.getInt(3)));
        }

        System.out.println(usersFind);

    }

    public void update(List<User> users, Scanner input){
        System.out.println("Enter the id in order to Update");
        int id = input.nextInt();
        User userToUpdate = users.get(id - 1);

        boolean updateStatus = true;

        while(updateStatus){

            System.out.println("Enter new Name");
            String newName = input.nextLine();
            userToUpdate.setOfficerName(newName);
            input.nextLine();

            System.out.println("Enter new Password");
            int newPassword = input.nextInt();
            userToUpdate.setPassword(newPassword);
            input.nextLine();

            System.out.println("User updated successfully!");
            updateStatus = false;
        }
        users.stream().forEach(System.out::println);
    }

    public void add(List<User> users, Scanner input) throws SQLException, ClassNotFoundException {
        boolean addStatus = true;
        while (addStatus){

            System.out.println("Enter user password");
            int password = input.nextInt();
            input.nextLine();

            System.out.println("Enter user name");
            String userName = input.nextLine();

            User user = new User(0, userName, password);

            Object executedQuery = CrudUtil.execute("INSERT INTO user(id, officer_name, password) VALUES (?,?,?)", user.getId(), user.getOfficerName(), user.getPassword());

            if(executedQuery != null){
                System.out.println("User added successfully!");
            } else {
                System.out.println("Something went wrong!");
            }

            System.out.println("Need to add another user?");
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
