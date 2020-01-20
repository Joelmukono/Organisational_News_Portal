import com.google.gson.Gson;
import dao.Sql2oUserDao;
import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import static spark.Spark.*;
public class App {

    public static void main(String[] args) {
        Sql2oUserDao userDao;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:h2:~/news.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";

        Sql2o sql2o = new Sql2o(connectionString, "", "");

        userDao = new Sql2oUserDao(sql2o);

        post("/user/new","application/json",(request,response)->{
            User user = gson.fromJson(request.body(), User.class);
            userDao.add(user);
            response.status(201);
            response.type("application/json");
            return gson.toJson(user);


        });

        get("users/","application/json",(request,response)->{
            response.type("application/json");
            return gson.toJson(userDao.getAll());
        });

        get("/user/:id","application/json",(request,response)->{
            response.type("application/json");
            int userId = Integer.parseInt(request.params("id"));
            response.type("application/json");
            return gson.toJson(userDao.findUserId(userId));
        });
    }
}
