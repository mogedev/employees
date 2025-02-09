package com.example.employees.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(
        title = "Employee API",
        description = "This API provides a set of endpoints to manage employee data. It allows you to perform basic CRUD (Create, Read, Update, Delete) operations on employee records, as well as retrieve employee information based on various criteria.",
        version = "1.0"
    )
)
public class SwaggerConfig {
}
