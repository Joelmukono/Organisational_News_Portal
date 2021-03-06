import com.google.gson.Gson;
import dao.Sql2oDepartmentDao;
import dao.Sql2oNewsDao;
import dao.Sql2oUserDao;
import models.Departments;
import models.News;
import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import static spark.Spark.*;
public class App {

    public static void main(String[] args) {
        Sql2oUserDao userDao;
        Sql2oDepartmentDao departmentDao;
        Sql2oNewsDao newsDao;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:postgresql://localhost:5432/news";;

        Sql2o sql2o = new Sql2o(connectionString, "joel", "password");

        userDao = new Sql2oUserDao(sql2o);
        departmentDao = new Sql2oDepartmentDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);

        post("/department/:departmentId/user/new/","application/json",(request,response)->{
            User user = gson.fromJson(request.body(), User.class);
            int depId = Integer.parseInt(request.params("departmentId"));
            user.setDepartmentsId(depId);
            userDao.add(user);
            response.status(201);
            response.type("application/json");
            return gson.toJson(user);


        });

        get("/users/","application/json",(request,response)->{
            response.type("application/json");
            return gson.toJson(userDao.getAll());
        });

        get("/user/:userId/","application/json",(request,response)->{
            response.type("application/json");
            int userId = Integer.parseInt(request.params("userId"));
            response.type("application/json");
            return gson.toJson(userDao.findUserId(userId));
        });


        post("/departments/new/","application/json",(request, response) -> {
            Departments departments = gson.fromJson(request.body(),Departments.class);
            departmentDao.add(departments);
            response.status(201);
            response.type("application/json");
            return gson.toJson(departments);

        });

        get("/departments/all/","application/json",(request, response) -> {
                    response.type("application/json");
                    return gson.toJson(departmentDao.getAll());

                });

        get("/department/:departmentId/","application/json",(request,response)->{
            response.type("application/json");
            int depId = Integer.parseInt(request.params("departmentId"));
            response.type("application/json");
            return gson.toJson(departmentDao.findDepId(depId));
        });

        post("/news/new/","application/json",(request, response) -> {
            News news = gson.fromJson(request.body(),News.class);
            newsDao.add(news);
            response.status(201);
            response.type("application/json");
            return gson.toJson(news);

        });

        get("/news/all/","application/json",(request, response) -> {
            response.type("application/json");
            return gson.toJson(newsDao.getAll());

        });

        get("/news/:newsId/","application/json",(request,response)->{
            response.type("application/json");
            int nwsId = Integer.parseInt(request.params("newsId"));
            response.type("application/json");
            return gson.toJson(newsDao.findNewsById(nwsId));
        });


        // FILTER
        after((request, response) ->{
            response.type("application/json");
        });
    }
}
