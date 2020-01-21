package dao;
import models.Departments;
import models.News;
import models.User;

import java.util.List;

public interface DepartmentDao {



        void add(Departments user);

        List<Departments> getAll();



    List<User> getAllUsersByDep(int id);

     Departments findDepId(int userId);

    List<News> getAllNewsByDep(int id);





    }

