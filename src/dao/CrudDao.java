package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public interface CrudDao<T> {

    void viewAll(List<T> list) throws SQLException, ClassNotFoundException;
    void delete(List<T> list, Scanner input) throws SQLException, ClassNotFoundException;
    void update(List<T> list, Scanner input) throws SQLException, ClassNotFoundException;
    void findById(List<T> list, Scanner input) throws SQLException, ClassNotFoundException;

    void add(List<T> list, Scanner input) throws SQLException, ClassNotFoundException;

}
