package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.UserDao;
import models.User;
import util.GlobalVar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class UserDaoImpl implements UserDao {

    public void viewAll() throws SQLException, ClassNotFoundException {
         ResultSet set =  CrudUtil.execute("SELECT * FROM user");
         ArrayList<User> usersFind = new ArrayList<>();

         while (set.next()){
             usersFind.add(new User(set.getInt(1), set.getString(2), set.getInt(3)));
         }
        System.out.println(usersFind);
    }

    public void delete(Scanner input) throws SQLException, ClassNotFoundException {
        System.out.println("Enter the user id");
        int id = input.nextInt();

        if(CrudUtil.execute("DELETE FROM user WHERE id = ?", id)){
            System.out.println("User has deleted");
        } else {
            System.out.println("Sorry user cannot be delete");
        }
    }

    public void findById(Scanner input) throws SQLException, ClassNotFoundException {
        System.out.println("Enter user id in order to Display!");
        int id = input.nextInt();

        ResultSet set = CrudUtil.execute("SELECT * FROM user WHERE id = ?", id);
            ArrayList<User> usersFind = new ArrayList<>();
        while(set.next()){
            usersFind.add(new User(set.getInt(1), set.getString(2), set.getInt(3)));
        }

        System.out.println(usersFind);

    }

    public void update(Scanner input) throws SQLException, ClassNotFoundException {
        System.out.println("Enter the id in order to Update");
        int id = input.nextInt();
//        User userToUpdate = users.get(id - 1);

        boolean updateStatus = true;

        while(updateStatus){

            System.out.println("Enter new Password");
            int newPassword = input.nextInt();
            input.nextLine();

            System.out.println("Enter new Name");
            String newName = input.nextLine();

            CrudUtil.execute("UPDATE user SET officer_name = ?, password = ? WHERE id = ?", newName, newPassword, id);

            System.out.println("User updated successfully!");
            updateStatus = false;
        }
    }

    public void add(Scanner input) throws SQLException, ClassNotFoundException {
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
    }

    public boolean loginUser(Scanner input) throws SQLException, ClassNotFoundException {

        String currentUser;

        System.out.println("Enter the Username");
        currentUser = input.nextLine();
        GlobalVar.userName = currentUser;
        input.nextLine();
        System.out.println("Enter the Password");
        String password = input.nextLine();

        ResultSet resultSet = CrudUtil.execute("SELECT id FROM user WHERE password = ?", password);

        if(resultSet.next()){
            GlobalVar.userId = resultSet.getInt(1);
            System.out.println("Current User is : " + GlobalVar.userName);
            return true;
        }
        System.out.println("Wrong credentials! please try again!");
        return false;
    }
}
