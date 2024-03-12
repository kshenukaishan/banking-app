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

    public static void clientSection(List<Client> clients, Scanner input) throws SQLException, ClassNotFoundException {

        String[] clientMenuItems = new String[6];

        clientMenuItems[0] = "(1) Add Client";
        clientMenuItems[1] = "(2) Find Client";
        clientMenuItems[2] = "(3) Update Client";
        clientMenuItems[3] = "(4) Delete Client";
        clientMenuItems[4] = "(5) View All Clients";
        clientMenuItems[5] = "(6) Exit";

        clientSubMenu(clients, input, clientMenuItems);

    }

    private static void clientSubMenu(List<Client> clients, Scanner input, String[] clientMenuItems) throws SQLException, ClassNotFoundException {
        while (true){
            int selectedMenuItem = MenuUtil.printMenu(clientMenuItems, input);

            switch (selectedMenuItem){
                case 0:
                    addClient(clients, input);
                    break;
                case 1:
                    findClientById(clients, input);
                    break;
                case 2:
                    updateClient(clients, input);
                    break;
                case 3:
                    deleteClient(clients, input);
                    break;
                case 4:
                    viewAllClients(clients);
                    break;
                case 5:
                    return;
            }
        }
    }

    private static void addClient(List<Client> clients, Scanner input) throws SQLException, ClassNotFoundException {
        clientDao.add(clients, input);
    }

    private static void findClientById(List<Client> clients, Scanner input) throws SQLException, ClassNotFoundException {
        clientDao.findById(clients, input);
    }

    private static void updateClient(List<Client> clients, Scanner input) throws SQLException, ClassNotFoundException {
        clientDao.update(clients, input);
    }

    private static void deleteClient(List<Client> clients, Scanner input) throws SQLException, ClassNotFoundException {
        clientDao.delete(clients, input);
    }

    private static void viewAllClients(List<Client> clients) throws SQLException, ClassNotFoundException {
        clientDao.viewAll(clients);
    }
}
