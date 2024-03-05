package models;

public class Client {

    private int clientId;
    private int accountNumber;
    private String name;
    private String address;

    public Client() {
    }

    public Client(int clientId, int accountNumber, String name, String address) {
        this.clientId = clientId;
        this.accountNumber = accountNumber;
        this.name = name;
        this.address = address;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", accountNumber=" + accountNumber +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
