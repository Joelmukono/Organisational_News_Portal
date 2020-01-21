package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentsTest {

    @Test
    public void getName_savesDepartmentNameCorrectly() {
        Departments departments = setDepartment();
        assertEquals("Finance Department",departments.getDepartmentName());
    }

    @Test
    public void getDescription_savesDescriptionCorrectly() {
        Departments departments = setDepartment();
        assertEquals("We finance stuff", departments.getDepartmentDescription());
    }

    @Test
    public void getNumOfEmployees_savesNumberOfEmployees() {
        Departments departments = setDepartment();
        assertEquals(3, departments.getNumberOfEmployees());
    }



    public Departments setDepartment(){
        return new Departments("Finance Department", "We finance stuff", 3,1);
    }
}