package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public interface CrudDao<T> {

    void viewAll() throws SQLException, ClassNotFoundException;
    void delete(Scanner input) throws SQLException, ClassNotFoundException;
    void update(Scanner input) throws SQLException, ClassNotFoundException;
    void findById(Scanner input) throws SQLException, ClassNotFoundException;
    void add(Scanner input) throws SQLException, ClassNotFoundException;

}
