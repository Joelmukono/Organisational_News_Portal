package dao;



import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import models.News;
import static org.junit.Assert.*;

public class Sql2oNewsDaoTest {

    private static Connection conn;
    private static Sql2oNewsDao newsDao;


    @BeforeClass
    public static void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/news_test";
        Sql2o sql2o = new Sql2o(connectionString, "joel", "password");
        newsDao = new Sql2oNewsDao(sql2o);
        conn = sql2o.open();

    }
    @After
    public void tearDown(){
        System.out.println("CLEARING DATABASE");
        newsDao.clearAll();
    }

    @Test
    public void add_news() {
        News new_n = setNews();
        newsDao.add(new_n);
        assertEquals(1, newsDao.getAll().size());
    }

    @Test
    public void findNews_returnsNews() {
        News departments = setNews();
        newsDao.add(departments);
        News departments2 = setNews();
        newsDao.add(departments2);
        assertEquals(2, newsDao.getAll().size());
    }

    @Test
    public void findById_returnsDepartmentBasedOnID() {
        News new_s = setNews();
        newsDao.add(new_s);
        int idOfDepartment = new_s.getNewsId();
        int idOfFoundDepartment = newsDao.findNewsById(new_s.getNewsId()).getNewsId();
        assertEquals(idOfDepartment, idOfFoundDepartment);
    }







    @AfterClass
    public static void afterClass() throws Exception {
        conn.close();
    }




    public News setNews(){
        return new News(1,"Building Apps");
    }
}

