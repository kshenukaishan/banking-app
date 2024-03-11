package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.ClientDao;
import models.Client;
import util.GlobalVar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ClientDaoImpl implements ClientDao {

    public void viewAll(List<Client> clients){
        clients.forEach(System.out::println);
    }

    public void delete(List<Client> clients, Scanner input){
        System.out.println("Enter the client id");
        int id = input.nextInt();
        clients.stream().filter(patient -> patient.getClientId() == id).findFirst();
        System.out.println("Client has deleted!");
        clients.stream().forEach(System.out::println);
    }

    public void findById(List<Client> clients, Scanner input) throws SQLException, ClassNotFoundException {
        System.out.println("Enter Client id in order to Display!");
        int id = input.nextInt();

        ResultSet set = CrudUtil.execute("SELECT * FROM client WHERE client_id = ?", id);
        ArrayList<Client> clientFind = new ArrayList<>();

        while(set.next()){
            clientFind.add(new Client(set.getInt(1), set.getInt(2), set.getString(3), set.getString(4), set.getInt(5)));
        }
        System.out.println(clientFind);

    }

    public void update(List<Client> clients, Scanner input){
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

    public void add(List<Client> clients, Scanner input) throws SQLException, ClassNotFoundException {
        boolean addStatus = true;
        while (addStatus) {

            System.out.println("Enter Client account number");
            int accountNumber = input.nextInt();
            input.nextLine();

            System.out.println("Enter Client name");
            String clientName = input.nextLine();

            System.out.println("Enter client address");
            String address = input.nextLine();

            System.out.println("Enter User id here");
            int userId = input.nextInt();

            Client client = new Client(0,accountNumber,clientName,address, userId);

            Object executedQuery = CrudUtil.execute("INSERT INTO client(client_id, account_number, name, address, user_id) VALUES (?,?,?,?,?)", client.getClientId(), client.getAccountNumber(), client.getName(), client.getAddress(), client.getUser_id());

            if(executedQuery != null){
                System.out.println("Client added successfully!");
            } else {
                System.out.println("Something went wrong!");
            }

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
