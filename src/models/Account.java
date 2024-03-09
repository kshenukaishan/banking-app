package models;

public class Account {

    private int account_id;
    private int number;
    private String pin;
    private String clientName;
    private double balance;
    private int client_client_id;

    public Account() {
    }

    public Account(int account_id, int number, String pin, String clientName, double balance, int client_client_id) {
        this.account_id = account_id;
        this.number = number;
        this.pin = pin;
        this.clientName = clientName;
        this.balance = balance;
        this.client_client_id = client_client_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getClient_client_id() {
        return client_client_id;
    }

    public void setClient_client_id(int client_client_id) {
        this.client_client_id = client_client_id;
    }

    @Override
    public String toString() {
        return "Account{" +
                "account_id=" + account_id +
                ", number=" + number +
                ", pin='" + pin + '\'' +
                ", clientName='" + clientName + '\'' +
                ", balance=" + balance +
                ", client_client_id=" + client_client_id +
                '}';
    }
}
