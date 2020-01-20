package dao;
import models.Departments;
import models.User;

import java.util.List;

public interface DepartmentDao {



        void add(Departments user);

        List<Departments> getAll();



    List<User> getAllDepByUser(int id);





    }

