package dao;
import models.Departments;
import java.util.List;

public interface Department {



        void add(Departments user);

        List<Departments> getAll();

        List<Departments> getUserByDep();

    Departments findUserId(int id);



        void deleteId(int id);

        void clearAll();

    }

