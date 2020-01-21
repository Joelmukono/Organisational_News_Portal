package dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import models.Departments;

import static org.junit.Assert.*;

public class Sql2oDepartmentDaoTest {

    private static Connection conn;
    private static Sql2oDepartmentDao departmentsDao;
    private static Sql2oUserDao usersDao;

    @BeforeClass
    public static void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/news_test";
        Sql2o sql2o = new Sql2o(connectionString, "joel", "password");
        usersDao = new Sql2oUserDao(sql2o);
        departmentsDao = new Sql2oDepartmentDao(sql2o);
        usersDao = new Sql2oUserDao(sql2o);
        conn = sql2o.open();

    }
    @After
    public void tearDown(){
        System.out.println("CLEARING DATABASE");
        departmentsDao.clearAll();
    }

    @Test
    public void add_departments() {
        Departments departments = setDepartments();
        departmentsDao.add(departments);
        assertEquals(1, departmentsDao.getAll().size());
    }

    @Test
    public void findDepartments_returnsDepartments() {
        Departments departments = setDepartments();
        departmentsDao.add(departments);
        Departments departments2 = setDepartments();
        departmentsDao.add(departments2);
        assertEquals(2, departmentsDao.getAll().size());
    }

    @Test
    public void findById_returnsDepartmentBasedOnID() {
        Departments departments = setDepartments();
        departmentsDao.add(departments);
        int idOfDepartment = departments.getDepartmentId();
        int idOfFoundDepartment = departmentsDao.findDepId(departments.getDepartmentId()).getDepartmentId();
        assertEquals(idOfDepartment, idOfFoundDepartment);
    }







    @AfterClass
    public static void afterClass() throws Exception {
        conn.close();
    }




    public Departments setDepartments(){
        return new Departments("Software","Building Apps",6,5);
    }
}