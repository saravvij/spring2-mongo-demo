package com.spring2.demo.service;

import com.spring2.demo.model.Employee;
import com.spring2.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> createEmployees(List<Employee> employees) {
        List<Employee> response = new ArrayList<>();
        employees.forEach(e -> response.add(this.employeeRepository.save(e)) );
        return response;
    }

    public List<Employee> getAllEmployees() {
        return this.employeeRepository.findAll();
    }

    public Employee findEmployeeById(String id) {
        return this.employeeRepository.findById(id).get();
    }
}
