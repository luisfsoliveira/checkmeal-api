package com.checkmeal.service;

import com.checkmeal.domain.Employee;
import com.checkmeal.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public List<Employee> findAllActive() {
        return employeeRepository.findByStatus(Boolean.TRUE);
    }

}
