package com.example.spring_testing_demo.services;

import com.example.spring_testing_demo.models.Employee;
import com.example.spring_testing_demo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class EmployeeServices {


    @Autowired

    private EmployeeRepository repository;

    //Get all employees
    public Iterable <Employee> getAllEmployees(){
        return repository.findAll();
    }

    // Get one Employee by id
    public Optional<Employee> getEmployeeById(Long id){
        return repository.findById(id);

    }
// Create employee

    public Employee createEmployee(Employee employee ) {
        return repository.save(employee);
    }

    // Update one employee
    public Employee updateEmployeeById (Long id, Employee employee) {
        employee.setId(id);
        return repository.save(employee);

    }
    // Delete one Employee
    public boolean deleteEmployeeById(Long id) {

        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}