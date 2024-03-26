package dao.custom;

import dao.CrudDao;
import models.User;

import java.sql.SQLException;
import java.util.Scanner;

public interface UserDao extends CrudDao<User> {
    boolean loginUser(Scanner input) throws SQLException, ClassNotFoundException;
}
