package dao;

import models.Client;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ClientDao {

    public static void viewAllClient(List<Client> clients){
        clients.forEach(System.out::println);
    }

    public static void deleteClient(List<Client> clients, Scanner input){
        System.out.println("Enter the client id");
        int id = input.nextInt();
        clients.stream().filter(patient -> patient.getClientId() == id).findFirst();
        System.out.println("Client has deleted!");
        clients.stream().forEach(System.out::println);
    }

    public static void findClientById(List<Client> clients, Scanner input){
        System.out.println("Enter Client id in order to Display!");
        int id = input.nextInt();
        Optional<Client> findClient = clients.stream().filter(client -> client.getClientId() == id).findFirst();
        System.out.println(findClient);
    }

    public static void addClient(List<Client> clients, Scanner input) {
        boolean addStatus = true;
        while (addStatus) {

            Client client = new Client();
            System.out.println("Enter Client id");
            int id = input.nextInt();
            client.setClientId(id);

            System.out.println("Enter Client name");
            String clientName = input.nextLine();
            client.setName(clientName);
            input.nextLine();

            System.out.println("Enter Client account number");
            int accountNumber = input.nextInt();
            client.setAccountNumber(accountNumber);
            input.nextLine();

            System.out.println("Enter client address");
            String address = input.nextLine();
            client.setAddress(address);
            clients.add(client);

            System.out.println("Client added successfully!");

            System.out.println("Need to add another client?");
            System.out.println("(1) Yes");
            System.out.println("(2) No");
            int answer = input.nextInt();

            if (answer != 1) {
                addStatus = false;
            } else {
                addStatus = true;
            }
        }
        clients.stream().forEach(System.out::println);
    }
}
