package com.checkmeal.datacreator;

import com.checkmeal.domain.Employee;
import com.checkmeal.domain.Role;
import com.checkmeal.repositories.EmployeeRepository;
import com.checkmeal.repositories.RoleRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class TestDataCreator {

    public static boolean isInitialized = false;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    ObjectMapper mapper = new ObjectMapper();

    public TestDataCreator() {
    }

    public void initDataSet() throws IOException {
        if (!isInitialized) {
            createRoles();
            createEmployees();
            isInitialized = true;
        }
    }

    public void createRoles() throws IOException {
        List<Role> listRoles = mapper.readValue(new ClassPathResource("data/roles.json").getFile(), new TypeReference<List<Role>>() {
        });
        listRoles.stream().forEach(r -> {
            roleRepository.save(r);
        });
    }

    public void createEmployees() throws IOException {
        List<Employee> listRoles = mapper.readValue(new ClassPathResource("data/employees.json").getFile(), new TypeReference<List<Employee>>() {
        });
        listRoles.stream().forEach(r -> {
            employeeRepository.save(r);
        });
    }
}
