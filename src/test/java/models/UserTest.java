package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void getName_savesUserNameCorrectly() {
        User users = setUser();
        assertEquals("user",users.getUserName());
    }

    @Test
    public void getDescription_savesDepartmentCorrectly() {
        User users = setUser();
        assertEquals("users", users.getDepartment());
    }

    @Test
    public void getPlacement_savesPlacememt() {
        User users = setUser();
        assertEquals("userPlace", users.getPlacement());
    }



    public User setUser(){
        return new User("user", "users", "userPlace",1);
    }

}