package com.checkmeal.service;

import com.checkmeal.datacreator.TestDataCreator;
import com.checkmeal.domain.Employee;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class EmployeeServiceIntegrationTest {

    List<Employee> originalEmployeeList;
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private EmployeeServiceImpl employeeService;

    @Autowired
    TestDataCreator testDataCreator;

    @Before
    public void setup() throws IOException {
        originalEmployeeList = mapper.readValue(
                new ClassPathResource("data/employees.json").getFile(), new TypeReference<List<Employee>>() {
                });
        testDataCreator.initDataSet();
    }

    @Test
    public void findAllActive_IntegrationTest() throws IOException {
        List<Employee> originalEmployeesFiltered = originalEmployeeList
                .stream()
                .filter(employee -> employee.getStatus() == true)
                .collect(Collectors.toList());
        //Call test method
        List<Employee> employeesDB = employeeService.findAllActive();

        //Assert Number of Employees
        Assert.assertEquals(originalEmployeesFiltered.size(), employeesDB.size());

        //Assert Name of Employees
        Assert.assertEquals(originalEmployeesFiltered.stream()
                        .map(e -> e.getFirstName())
                        .collect(Collectors.toList()),
                employeesDB.stream()
                        .map(e -> e.getFirstName())
                        .collect(Collectors.toList()));
    }

    @Test
    public void findAll_IntegrationTest() throws IOException {
        List<Employee> employeesDB = employeeService.findAll();
        //Assert Number of Employees
        Assert.assertEquals(originalEmployeeList.size(), employeesDB.size());
        //Assert Name of Employees
        Assert.assertEquals(originalEmployeeList.stream().map(e -> e.getFirstName()).collect(Collectors.toList()),
                employeesDB.stream().map(e -> e.getFirstName()).collect(Collectors.toList()));
    }


}
