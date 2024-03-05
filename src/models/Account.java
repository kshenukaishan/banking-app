package models;

public class Account {

    private int id;
    private int number;
    private String clientName;
    private double balance;

    public Account() {
    }

    public Account(int id, int number, String clientName, double balance) {
        this.id = id;
        this.number = number;
        this.clientName = clientName;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", number=" + number +
                ", clientName='" + clientName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
