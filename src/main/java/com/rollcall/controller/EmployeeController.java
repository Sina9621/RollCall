package com.rollcall.controller;

import com.rollcall.model.Employee;
import com.rollcall.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(value = "/main/employee/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        return employeeService.create(employee);
    }

    @GetMapping(value = "main/employee/get", produces = "application/json")
    public ResponseEntity<Employee> get(@RequestParam(value = "id") Long id) {
        return employeeService.get(id);
    }

    @GetMapping(value = "main/employee/get/all", produces = "application/json")
    public ResponseEntity<List<Employee>> getAll() {
        return employeeService.getAll();
    }

    @PutMapping(value = "main/employee/edit", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Employee> edit(@RequestBody Employee employee) {
       return employeeService.edit(employee);
    }
}