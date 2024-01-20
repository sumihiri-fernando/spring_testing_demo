package com.example.spring_testing_demo.controllers;

import com.example.spring_testing_demo.models.Employee;
import com.example.spring_testing_demo.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/employees")
public class EmployeeController {

    private final EmployeeServices services;

    @Autowired
    public EmployeeController(EmployeeServices services) {
        this.services = services;
    }

    // Get all employees
    // GET: /api/employees
    @GetMapping()
    public Iterable<Employee> getAllEmployees() {
        return services.getAllEmployees();
    }

    // Get one employee by id
    // GET: /api/employees/{id}
    @GetMapping("/{employeeId}")
    public Optional<Employee> getEmployeeById(@PathVariable Long employeeId) {
        return services.getEmployeeById(employeeId);
    }

    // Create one user
    // POST: /api/employees
    @PostMapping()
    public Employee postEmployee(@RequestBody Employee employee) {
        return services.createEmployee(employee);
    }

    // Put one user
    // PUT: /api/employees/{id}
    @PutMapping("/{employeeId}")
    public Employee putEmployee(@PathVariable Long employeeId, @RequestBody Employee employee) {
        return services.updateEmployeeById(employeeId, employee);
    }

    // Delete one user
    // DELETE: /api/employees/{id}
    @DeleteMapping("/{employeeId}")
    public boolean deleteOneById(@PathVariable Long employeeId) {
        return services.deleteEmployeeById(employeeId);
    }
}
