package com.rollcall.service;

import com.rollcall.model.Employee;
import com.rollcall.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {


    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public ResponseEntity<Employee> create(Employee employee) {
        if (employee.getId() == null) {
            employee.setCardKey(employee.getName().charAt(0) + employee.getName().charAt(1) + employee.getLastName().charAt(0) + employee.getLastName().charAt(1) + "*");
            Employee result = employeeRepository.save(employee);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } else {
            return (ResponseEntity<Employee>) ResponseEntity.badRequest();
        }
    }

    public ResponseEntity<Employee> get(Long id) {
        Employee result = employeeRepository.getOne(id);
        return (result != null) ? ResponseEntity.status(HttpStatus.OK).body(result) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }

    public ResponseEntity<List<Employee>> getAll() {
        List<Employee> result = employeeRepository.findAll();
        return (result != null) ? ResponseEntity.status(HttpStatus.OK).body(result) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }

    public ResponseEntity<Employee> edit(Employee employee) {
        if (employee != null) {
            Employee result = employeeRepository.save(employee);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } else {
            return (ResponseEntity<Employee>) ResponseEntity.badRequest();
        }
    }
}
