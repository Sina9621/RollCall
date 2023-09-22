package com.rollcall.controller;

import com.rollcall.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.rollcall.repository.EmployeeRepository;

@RestController
public class EmployeeController {

    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostMapping(value = "/main/employee/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Employee> create(@RequestBody Employee employee){

        if (employee.getId() == null) {
            employee.setCardKey(employee.getName().charAt(0)+employee.getName().charAt(1)+employee.getLastName().charAt(0)+employee.getLastName().charAt(1)+"*");
            Employee result = employeeRepository.save(employee);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        }else {
            return (ResponseEntity<Employee>) ResponseEntity.badRequest();
        }
    }
}
