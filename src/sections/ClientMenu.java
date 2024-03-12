package sections;

import dao.DaoFactory;
import dao.custom.ClientDao;
import dao.custom.impl.ClientDaoImpl;
import models.Client;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ClientMenu {

    private static ClientDao clientDao = DaoFactory.getDao(DaoFactory.DaoType.CLIENT);

    public static void clientSection(Scanner input) throws SQLException, ClassNotFoundException {

        String[] clientMenuItems = new String[6];

        clientMenuItems[0] = "(1) Add Client";
        clientMenuItems[1] = "(2) Find Client";
        clientMenuItems[2] = "(3) Update Client";
        clientMenuItems[3] = "(4) Delete Client";
        clientMenuItems[4] = "(5) View All Clients";
        clientMenuItems[5] = "(6) Exit";

        clientSubMenu(input, clientMenuItems);

    }

    private static void clientSubMenu(Scanner input, String[] clientMenuItems) throws SQLException, ClassNotFoundException {
        while (true){
            int selectedMenuItem = MenuUtil.printMenu(clientMenuItems, input);

            switch (selectedMenuItem){
                case 0:
                    addClient(input);
                    break;
                case 1:
                    findClientById(input);
                    break;
                case 2:
                    updateClient(input);
                    break;
                case 3:
                    deleteClient(input);
                    break;
                case 4:
                    viewAllClients();
                    break;
                case 5:
                    return;
            }
        }
    }

    private static void addClient(Scanner input) throws SQLException, ClassNotFoundException {
        clientDao.add(input);
    }

    private static void findClientById(Scanner input) throws SQLException, ClassNotFoundException {
        clientDao.findById(input);
    }

    private static void updateClient(Scanner input) throws SQLException, ClassNotFoundException {
        clientDao.update(input);
    }

    private static void deleteClient(Scanner input) throws SQLException, ClassNotFoundException {
        clientDao.delete(input);
    }

    private static void viewAllClients() throws SQLException, ClassNotFoundException {
        clientDao.viewAll();
    }
}
