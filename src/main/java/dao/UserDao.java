package dao;
import models.User;
import java.util.List;

public interface UserDao {

    void add(User user);

    List<User> getAll();

    User findUserId(int id);



    void deleteId(int id);

    void clearAll();






}
