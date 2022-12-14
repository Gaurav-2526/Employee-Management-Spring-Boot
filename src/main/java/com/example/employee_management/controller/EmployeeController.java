package com.example.employee_management.controller;

import com.example.employee_management.model.Employee;
import com.example.employee_management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @PostMapping("/employees")
    public Employee add(@RequestBody Employee employee) {
        return employeeService.add(employee);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getById(@PathVariable long id) {
        return ResponseEntity.ok(employeeService.getById(id));
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateById(@PathVariable long id, @RequestBody Employee empDetails) {
        return ResponseEntity.ok(employeeService.updateById(id, empDetails));
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteById(@PathVariable long id) {
        employeeService.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);
        return ResponseEntity.ok(response);
    }
}
