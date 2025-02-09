package com.example.employees;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootTest
@TestPropertySource(value = {"classpath:application-test.properties"})
class EmployeesApplicationTests {

    @Test
    void contextLoads() {
    }

}
