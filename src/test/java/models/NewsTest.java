package models;
import org.junit.Test;
import static org.junit.Assert.*;

public class NewsTest {

    @Test
    public void getName_savesNewsNameCorrectly() {
        News new_s = setNews();
        assertEquals("New news",new_s.getDescription());
    }

    @Test
    public void getDescription_savesDescriptionCorrectly() {
        News departments = setNews();
        assertEquals("New news", departments.getDescription());
    }





    public News setNews(){
        return new News(1, "New news");
    }



}