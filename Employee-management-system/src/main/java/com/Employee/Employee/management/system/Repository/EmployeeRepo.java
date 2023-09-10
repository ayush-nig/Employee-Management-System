package com.Employee.Employee.management.system.Repository;

import com.Employee.Employee.management.system.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {                //JpaRepository is used to perform CRUD operations
}                                                                                   //in Database therefore it is accessed to EmployeeRepo.
