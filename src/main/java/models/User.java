package models;

public class User {

    private int userId;
    private String userName;
    private String department;
    private String placement;

    public User(int id, String userName,String department, String placement){
        this.userId = id;
        this.userName = userName;
        this.department = department;
        this.placement = placement;

    }

    public void setId(int id){
        this.userId=id;
    }
}
