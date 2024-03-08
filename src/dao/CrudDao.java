package dao;

import java.util.List;
import java.util.Scanner;

public interface CrudDao<T> {

    void viewAll(List<T> list);
    void delete(List<T> list, Scanner input);
    void update(List<T> list, Scanner input);
    void findById(List<T> list, Scanner input);

    void add(List<T> list, Scanner input);

}
