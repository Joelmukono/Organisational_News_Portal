package dao;

import models.Departments;
import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import java.util.List;


public class Sql2oNewsDao implements NewsDao {
    private final Sql2o sql2o;

    public Sql2oNewsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(News news) {
        String sql = "INSERT INTO news (description) VALUES (:description)";
        try (Connection con = sql2o.open()) {
            int newsId = (int) con.createQuery(sql, true).bind(news).executeUpdate().getKey();
            news.setNewsId(newsId);

        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<News> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM news").executeAndFetch(News.class);

        }
    }

    @Override
    public News findNewsById(int newsId){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM news WHERE newsId = :newsId")
                    .addParameter("newsId",newsId).executeAndFetchFirst(News.class);
        }

    }

}
