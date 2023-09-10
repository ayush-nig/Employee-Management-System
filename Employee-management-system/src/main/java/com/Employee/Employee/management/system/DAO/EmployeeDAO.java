package com.Employee.Employee.management.system.DAO;

import com.Employee.Employee.management.system.Entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getallemployees();
    public void saveEmployee(Employee employee);
    Employee getEmployeebyId(long id);
    public void deleteEmployeebyid(long id);
}
