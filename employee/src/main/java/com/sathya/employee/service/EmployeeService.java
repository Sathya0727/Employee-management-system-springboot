package com.sathya.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sathya.employee.model.Employee;

@Service
public class EmployeeService {

    private List<Employee> employees = new ArrayList<>();

    // Add Employee
    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    // Get All Employees
    public List<Employee> getAllEmployees() {
        return employees;
    }

    // Get Employee by ID
    public Employee getEmployeeById(int id) {
        return employees.stream()
                .filter(emp -> emp.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Update Employee
    public Employee updateEmployee(int id, Employee updatedEmployee) {
        Employee existing = getEmployeeById(id);
        if (existing != null) {
            existing.setName(updatedEmployee.getName());
            existing.setRole(updatedEmployee.getRole());
            existing.setSalary(updatedEmployee.getSalary());
        }
        return existing;
    }

    // Delete Employee
    public String deleteEmployee(int id) {
        Employee employee = getEmployeeById(id);
        if (employee != null) {
            employees.remove(employee);
            return "Employee deleted successfully";
        }
        return "Employee not found";
    }
}