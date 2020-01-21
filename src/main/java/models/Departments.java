package models;

import java.util.Objects;

public class Departments {


    private String departmentName;
    private String departmentDescription;
    private int numberOfEmployees;
    private int departmentId;

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    private int newsId;

    public Departments(String departmentName,String departmentDescription,int numberOfEmployees,int departmentId){
        this.departmentDescription = departmentDescription;
        this.departmentName = departmentName;
        this.numberOfEmployees = numberOfEmployees;
        this.departmentId = departmentId;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departments that = (Departments) o;
        return numberOfEmployees == that.numberOfEmployees &&
                departmentId == that.departmentId &&
                newsId == that.newsId &&
                departmentName.equals(that.departmentName) &&
                departmentDescription.equals(that.departmentDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentName, departmentDescription, numberOfEmployees, departmentId, newsId);
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentDescription() {
        return departmentDescription;
    }

    public void setDepartmentDescription(String departmentDescription) {
        this.departmentDescription = departmentDescription;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}
