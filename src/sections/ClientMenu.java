package sections;

import dao.ClientDao;
import models.Client;

import java.util.List;
import java.util.Scanner;

public class ClientMenu {

    public static void clientSection(List<Client> clients, Scanner input){

        String[] clientMenuItems = new String[6];

        clientMenuItems[0] = "(1) Add Client";
        clientMenuItems[1] = "(2) Find Client";
        clientMenuItems[2] = "(3) Update Client";
        clientMenuItems[3] = "(4) Delete Client";
        clientMenuItems[4] = "(5) View All Clients";
        clientMenuItems[5] = "(6) Exit";

        clientSubMenu(clients, input, clientMenuItems);

    }

    private static void clientSubMenu(List<Client> clients, Scanner input, String[] clientMenuItems){
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

    private static void addClient(List<Client> clients, Scanner input){
        ClientDao.addClient(clients, input);
    }

    private static void findClientById(List<Client> clients, Scanner input){
        ClientDao.findClientById(clients, input);
    }

    private static void updateClient(List<Client> clients, Scanner input){
        ClientDao.updateClient(clients, input);
    }

    private static void deleteClient(List<Client> clients, Scanner input){
        ClientDao.deleteClient(clients, input);
    }

    private static void viewAllClients(List<Client> clients){
        ClientDao.viewAllClient(clients);
    }
}
