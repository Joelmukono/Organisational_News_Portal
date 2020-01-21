package dao;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import models.User;
import static org.junit.Assert.*;

public class Sql2oUserDaoTest {

    private static Connection conn;
    private static Sql2oUserDao userDao;


    @BeforeClass
    public static void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/news_test";
        Sql2o sql2o = new Sql2o(connectionString, "joel", "password");
        userDao = new Sql2oUserDao(sql2o);
        conn = sql2o.open();

    }
    @After
    public void tearDown(){
        System.out.println("CLEARING DATABASE");
        userDao.clearAll();
    }

    @Test
    public void add_news() {
        User newUser = setUser();
        userDao.add(newUser);
        assertEquals(1, userDao.getAll().size());
    }

    @Test
    public void findNews_returnsNews() {
        User departments = setUser();
        userDao.add(departments);
        User departments2 = setUser();
        userDao.add(departments2);
        assertEquals(2, userDao.getAll().size());
    }

    @Test
    public void findById_returnsDepartmentBasedOnID() {
        User new_s = setUser();
        userDao.add(new_s);
        int idOfDepartment = new_s.getUserId();
        int idOfFoundDepartment = userDao.findUserId(new_s.getUserId()).getUserId();
        assertEquals(idOfDepartment, idOfFoundDepartment);
    }







    @AfterClass
    public static void afterClass() throws Exception {
        conn.close();
    }




    public User setUser(){
        return new User("jlmno","Building Apps","apps",1);
    }

}