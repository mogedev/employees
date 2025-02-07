package com.example.employees.service;

import com.example.employees.dto.EmployeeDTO;
import com.example.employees.enums.Gender;
import com.example.employees.model.Employee;
import com.example.employees.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
public class EmployeeServiceIntegrationTest {

    @TestConfiguration
    static class EmployeeServiceImplTestConfiguration {
        @Autowired
        private EmployeeRepository employeeRepository;

        @Bean
        public EmployeeService employeeService() {
            return new EmployeeServiceImp(employeeRepository);
        }
    }

    @Autowired
    private EmployeeService employeeService;

    @MockitoBean
    private EmployeeRepository employeeRepository;


    @BeforeEach
    public void setUp() {
        Employee employee = new Employee(1L,  "Maria", "Guadalupe", "Garcia", "Rodriguez", "23", Gender.FEMALE, LocalDate.parse("10-09-1996", DateTimeFormatter.ofPattern("dd-MM-yyyy")), "Developer");
        Employee employeeUpdated = new Employee(1L,  "Maria", "Rosa", "Garcia", "Rodriguez", "23", Gender.FEMALE, LocalDate.parse("10-09-1996", DateTimeFormatter.ofPattern("dd-MM-yyyy")), "Developer");


        Mockito.when(employeeRepository.findAll())
                .thenReturn(List.of(employee));

        Mockito.when(employeeRepository.findById(1L))
                .thenReturn(Optional.of(employee));
        Mockito.when(employeeRepository.save(Mockito.any(Employee.class)))
                .thenReturn(employeeUpdated);
    }

    @Test
    public void whenValidName_thenEmployeesShouldBeFound() {
        List<EmployeeDTO> found = employeeService.findAllEmployees();

        assertThat(found.size()).isEqualTo(1);
    }

    @Test
    public void whenUpdateEmployee_thenEmployeeShouldBeUpdated() {
        EmployeeDTO employeeDTO = new EmployeeDTO(1L, "Maria", "Rosa", "Garcia", "Rodriguez", "23", Gender.FEMALE, LocalDate.parse("10-09-1996", DateTimeFormatter.ofPattern("dd-MM-yyyy")), "Developer");

        EmployeeDTO updatedEmployee = employeeService.updateEmployee(1L, employeeDTO);
        assertThat(updatedEmployee.secondName()).isEqualTo("Rosa");

    }

}
