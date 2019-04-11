package com.spring2.demo.controller;

import com.spring2.demo.model.Employee;
import com.spring2.demo.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final Logger logger = Logger.getLogger(EmployeeController.class.getName());
    private EmployeeService employeeService;

    public  EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(this.employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable("id") String id) {
        logger.info("Finding Employee by id = " + id);
        Employee e = this.employeeService.findEmployeeById(id);
        if(e == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<List<Employee>> createEmployees(@RequestBody List<Employee> employees) {
       logger.info("Creating employees = " + employees);
       List<Employee> employeesResponse = this.employeeService.createEmployees(employees);
       logger.info("Employees creation successful");
       return new ResponseEntity<>(employeesResponse, HttpStatus.CREATED);

    }
}
