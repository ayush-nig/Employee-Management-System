package com.Employee.Employee.management.system.DAO;

import com.Employee.Employee.management.system.Entity.Employee;
import com.Employee.Employee.management.system.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DAOimpl implements EmployeeDAO {
    @Autowired
    private EmployeeRepo employeeRepository;
    @Override
    public List<Employee> getallemployees() {
        return this.employeeRepository.findAll();                        //A method of JpaRepository to get list of all Employees.
    }

    @Override
    public void saveEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeebyId(long id) {
        Optional<Employee> optional=employeeRepository.findById(id);
        Employee employee=null;
        if(optional.isPresent())
        {
            employee= optional.get();
        }
        else
        {
            throw new RuntimeException("Employee not found for id : "+id);
        }
        return employee;
    }

    @Override
    public void deleteEmployeebyid(long id) {
        this.employeeRepository.deleteById(id);
    }
}
