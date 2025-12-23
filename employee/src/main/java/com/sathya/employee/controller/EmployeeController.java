package com.sathya.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sathya.employee.model.Employee;
import com.sathya.employee.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public String home() {
        return "Employee Management System is running";
    }

    // Add employee (HTML form compatible)
    @PostMapping("/add")
    public String addEmployee(
            @RequestParam int id,
            @RequestParam String name,
            @RequestParam String role,
            @RequestParam double salary) {

        service.addEmployee(new Employee(id, name, role, salary));
        return "Employee added successfully";
    }

    // View all employees
    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    // Delete employee
    @PostMapping("/delete")
    public String deleteEmployee(@RequestParam int id) {
        return service.deleteEmployee(id);
    }
}
