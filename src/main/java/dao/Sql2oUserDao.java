package dao;
import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import java.util.List;


public class Sql2oUserDao implements UserDao {

    private final Sql2o sql2o;
    public Sql2oUserDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void add(User user){
        String sql = "INSERT INTO users (userName, placement, department) VALUES (:userName, :placement, :department)";
        try(Connection con = sql2o.open()){
            int userId = (int) con.createQuery(sql,true).bind(user).executeUpdate().getKey();
            user.setUserId(userId);

        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<User> getAll(){
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM users").executeAndFetch(User.class);

        }
    }
    @Override
    public User findUserId(int userId){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM users WHERE userId = :userId")
                    .addParameter("userId",userId).executeAndFetchFirst(User.class);
        }

    }

    @Override
    public void deleteId(int id){
        String sql = "DELETE from users WHERE id=:userId";
        try (Connection con = sql2o.open()){
            con.createQuery(sql).addParameter("id",id).executeUpdate();
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAll(){
        String sql ="DELETE FROM users";
        try(Connection con = sql2o.open()){
            con.createQuery(sql).executeUpdate();
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }


}
