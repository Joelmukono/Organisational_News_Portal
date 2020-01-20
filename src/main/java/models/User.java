package models;

import java.util.Objects;

public class User {

    private int userId;
    private String userName;
    private String department;
    private String placement;

    public User(String userName,String department, String placement){
        this.userName = userName;
        this.department = department;
        this.placement = placement;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId &&
                userName.equals(user.userName) &&
                department.equals(user.department) &&
                placement.equals(user.placement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, department, placement);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPlacement() {
        return placement;
    }

    public void setPlacement(String placement) {
        this.placement = placement;
    }

    public void setId(int id){
        this.userId=id;
    }
}
