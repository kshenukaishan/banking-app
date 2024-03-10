package models;

public class User {

    private int id;
    private String officerName;
    private int password;

    public User() {
    }

    public User(int id, String officerName, int password) {
        this.id = id;
        this.officerName = officerName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOfficerName() {
        return officerName;
    }

    public void setOfficerName(String officerName) {
        this.officerName = officerName;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + officerName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
