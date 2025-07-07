package com.akanksha.employeemanager.service;

import com.akanksha.employeemanager.model.Employee;
import com.akanksha.employeemanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Employee existing = employeeRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(updatedEmployee.getName());
            existing.setEmail(updatedEmployee.getEmail());
            existing.setJobTitle(updatedEmployee.getJobTitle());
            existing.setPhone(updatedEmployee.getPhone());
            return employeeRepository.save(existing);
        } else {
            return null;
        }
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
