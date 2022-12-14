package com.example.employee_management.service;

import com.example.employee_management.exception.ResourceNotFoundException;
import com.example.employee_management.model.Employee;
import com.example.employee_management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    public Employee add(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee getById(long id){
        return employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee nor exists with id "+ id));
    }

    public Employee updateById(long id , Employee employee){
        Employee emp = this.getById(id);
        emp.setFirstName(employee.getFirstName());
        emp.setLastName((employee.getLastName()));
        emp.setEmailId(employee.getEmailId());
        return employeeRepository.save(emp);
    }

    public void deleteById(long id){
        getById(id);
        employeeRepository.deleteById(id);
    }
}
