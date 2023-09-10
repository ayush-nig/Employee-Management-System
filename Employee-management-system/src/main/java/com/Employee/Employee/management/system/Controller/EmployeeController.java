package com.Employee.Employee.management.system.Controller;

import com.Employee.Employee.management.system.DAO.EmployeeDAO;
import com.Employee.Employee.management.system.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDAO employeeDAO;
    @GetMapping("/EmployeesList")
    public String viewHomePage(Model model)
    {
        model.addAttribute("listEmployees",employeeDAO.getallemployees());              //"listEmployees" is the key which will be used in html file to access the respective value.
        return "index";                         // Name of the html file which gets returned.
    }
    @GetMapping("/showNewEmployeeForm")
    public String showEmployeeForm(Model model)
    {
        Employee employee=new Employee();                   //To take input by creating Object.
        model.addAttribute("employeedata",employee);
        return "newEmployee";
    }
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employeedata") Employee employee)               //input will come as a parameter from key employeedata and gets stored in the employee argument.
    {
        this.employeeDAO.saveEmployee(employee);                                       //This will save the employee to a database.
        return "redirect:/EmployeesList";
    }
    @GetMapping("/showFormforUpdate/{id}")
    public String FormforUpdate(@PathVariable(value = "id") long id, Model model)
    {
        Employee employee=employeeDAO.getEmployeebyId(id);
        model.addAttribute("employee", employee);
        return "UpdateEmployee";
    }
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id)
    {
        this.employeeDAO.deleteEmployeebyid(id);
        return "redirect:/EmployeesList";
    }
}
