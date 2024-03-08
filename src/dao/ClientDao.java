package dao;

import models.Client;
import models.User;

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

    public static void updateClient(List<Client> clients, Scanner input){
        System.out.println("Enter the id in order to Update");
        int id = input.nextInt();
        Client clientToUpdate = clients.get(id - 1);

        boolean updateStatus = true;

        while(updateStatus){

            System.out.println("Enter new Name");
            String newName = input.nextLine();
            clientToUpdate.setName(newName);
            input.nextLine();

            System.out.println("Enter new Account Number");
            int newAcc = input.nextInt();
            clientToUpdate.setAccountNumber(newAcc);
            input.nextLine();

            System.out.println("Enter new Address");
            String newAddress = input.nextLine();
            clientToUpdate.setAddress(newAddress);

            System.out.println("Client updated successfully!");
            updateStatus = false;
        }
        clients.stream().forEach(System.out::println);

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
