package dao;

import models.Departments;
import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oDepartmentDao implements DepartmentDao {

    private final Sql2o sql2o;

    public Sql2oDepartmentDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Departments departments) {
        String sql = "INSERT INTO departments (departmentName, departmentDescription, numberOfEmployees,newsId) VALUES (:departmentName, :departmentDescription, :numberOfEmployees,:newsId)";
        try (Connection con = sql2o.open()) {
            int depId = (int) con.createQuery(sql, true).bind(departments).executeUpdate().getKey();
            departments.setDepartmentId(depId);

        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Departments> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM departments").executeAndFetch(Departments.class);

        }
    }


    @Override
    public List<User> getAllUsersByDep(int departmentIds) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM departments WHERE departmentsIds = :departmentId").addParameter("departmentIds", departmentIds)
                    .executeAndFetch(User.class);
        }


    }

    @Override
    public Departments findDepId(int departmentId){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM departments WHERE departmentId = :departmentId")
                    .addParameter("departmentId",departmentId).executeAndFetchFirst(Departments.class);
        }

    }

}





